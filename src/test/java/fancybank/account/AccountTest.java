package fancybank.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fancybank.account.CheckAccount;

import fancybank.stock.Stock;
import fancybank.stock.StockMarket;

public class AccountTest {

    @Test
    public void TestCheckAccount() {
        // Test accout name
        CheckAccount checkAccount1 = new CheckAccount(10001);
        Assertions.assertEquals(10001, checkAccount1.getAccountNumber());
        Assertions.assertEquals(0.00, checkAccount1.getBalance().get());

        CheckAccount checkAccount2 = new CheckAccount(10002, -100, "USD");
        Assertions.assertEquals(10002, checkAccount2.getAccountNumber());
        Assertions.assertEquals(0, checkAccount2.getBalance().get());

        CheckAccount checkAccount3 = new CheckAccount(10003, 200, "USD");
        checkAccount3.getBalance().add(100);
        Assertions.assertEquals(300, checkAccount3.getBalance().get());
        checkAccount3.getBalance().subtract(200);
        Assertions.assertEquals(100, checkAccount3.getBalance().get());
        checkAccount3.getBalance().subtract(200);
        Assertions.assertEquals(100, checkAccount3.getBalance().get());

        Account checkAccount5 = new CheckAccount(10004);
        Assertions.assertTrue(checkAccount5 instanceof CheckAccount);
    }

    @Test
    public void TestSavingAccouunt() {
        SavingAccount savingAccount1 = new SavingAccount(10001);
        Assertions.assertEquals(10001, savingAccount1.getAccountNumber());
        Assertions.assertEquals(0, savingAccount1.getBalance().get());
        savingAccount1.getBalance().set(100);
        Assertions.assertEquals(100, savingAccount1.getBalance().get());
        // saving account balance does not allow overdraft
        Assertions.assertFalse(savingAccount1.getBalance().isSufficient(200));
        savingAccount1.withdraw(200);
        Assertions.assertEquals(100, savingAccount1.getBalance().get());

        SavingAccount savingAccount2 = new SavingAccount(10002, 200, "USD");
        Assertions.assertEquals(200, savingAccount2.getBalance().get());

        Account savingAccount3 = new SavingAccount(10002, 200, "USD");
        Assertions.assertTrue(savingAccount3 instanceof SavingAccount);
    }

    @Test
    public void TestAccountTransfer() {
        SavingAccount savingAccount1 = new SavingAccount(10001, 10000, "USD");
        CheckAccount checkAccount1 = new CheckAccount(10002, 100, "USD");
        savingAccount1.transferTo(checkAccount1, 100);
        Assertions.assertEquals(9900, savingAccount1.getBalance().get());
        Assertions.assertEquals(200, checkAccount1.getBalance().get());

        // insufficient balance, do nothing
        savingAccount1.transferTo(checkAccount1, 10000);
        Assertions.assertEquals(9900, savingAccount1.getBalance().get());
        Assertions.assertEquals(200, checkAccount1.getBalance().get());

    }

    @Test
    public void TestExchange() {
        CheckAccount checkAccount1 = new CheckAccount(10001, 150, "USD");
        CheckAccount checkAccount2 = new CheckAccount(10002, 0, "CNY");
        Balance exBalance = new Balance(100, "USD");
        boolean result1 = checkAccount1.exchangeTo(checkAccount2, exBalance);
        Assertions.assertTrue(result1);
        Assertions.assertEquals(50, checkAccount1.getBalance().get());
        Assertions.assertEquals(700, checkAccount2.getBalance().get());
        boolean result2 = checkAccount1.exchangeTo(checkAccount2, exBalance);
        Assertions.assertFalse(result2);
        Assertions.assertEquals(50, checkAccount1.getBalance().get());
        Assertions.assertEquals(700, checkAccount2.getBalance().get());
        Balance exBalance2 = new Balance(70, "CNY");
        boolean result3 = checkAccount1.exchangeTo(checkAccount2, exBalance2);
        Assertions.assertTrue(result3);
        Assertions.assertEquals(40, checkAccount1.getBalance().get());
        Assertions.assertEquals(770, checkAccount2.getBalance().get());

    }

    @Test
    public void TestBuySellStock() {
        CheckAccount checkAccount1 = new CheckAccount(10001, 10000, "USD");
        SecurityAccount securityAccount = new SecurityAccount(10001, 10000);
        Assertions.assertTrue(securityAccount instanceof Tradable);
        StockMarket stockMarket = StockMarket.getInstance();
        stockMarket.addStock(new Stock("AAPL", "Apple", 100));
        stockMarket.getStock("AAPL").setPrice(100); // in case if alrady existed
        stockMarket.addStock(new Stock("GOOG", "Google", 200));
        stockMarket.getStock("GOOG").setPrice(200); // in case if alrady existed
        stockMarket.addStock(new Stock("MSFT", "Microsoft", 300));
        stockMarket.getStock("MSFT").setPrice(300); // in case if alrady existed
        checkAccount1.transferTo(securityAccount, 7000);
        Assertions.assertEquals(17000, securityAccount.getBalance().get());

        // buy stocks
        boolean result = securityAccount.buyStock("AAPL", 10);
        Assertions.assertTrue(result);
        Assertions.assertEquals(100,
                securityAccount.getStockHoldingList().getStockHoldingList("AAPL").get(0).getBoughtPrice());
        Assertions.assertEquals(10,
                securityAccount.getStockHoldingList().getStockHoldingList("AAPL").get(0).getQuantity());
        result = securityAccount.buyStock(new Stock("GOOG"), 10);
        Assertions.assertTrue(result);
        result = securityAccount.buyStock(new Stock("MSFT", "Microsoft"), 10);
        Assertions.assertTrue(result);
        // simulate the price change
        StockMarket.getInstance().getStock("GOOG").setPrice(300);
        result = securityAccount.buyStock(new Stock("GOOG"), 20);
        Assertions.assertTrue(result);
        result = securityAccount.buyStock(new Stock("MSFT", "Microsoft"), 100);
        Assertions.assertFalse(result);
        Assertions.assertEquals(5000, securityAccount.getBalance().get());
        Assertions.assertEquals(1, securityAccount.getStockHoldingList().getStockHoldingList("AAPL").size());
        Assertions.assertEquals(10,
                securityAccount.getStockHoldingList().getStockHoldingList("AAPL").get(0).getQuantity());
        Assertions.assertEquals(2, securityAccount.getStockHoldingList().getStockHoldingList("GOOG").size());
        Assertions.assertEquals(10,
                securityAccount.getStockHoldingList().getStockHoldingList("GOOG").get(0).getQuantity());
        Assertions.assertEquals(20,
                securityAccount.getStockHoldingList().getStockHoldingList("GOOG").get(1).getQuantity());
        Assertions.assertEquals(1, securityAccount.getStockHoldingList().getStockHoldingList("MSFT").size());
        Assertions.assertEquals(10,
                securityAccount.getStockHoldingList().getStockHoldingList("MSFT").get(0).getQuantity());
        Assertions.assertEquals(4, securityAccount.getStockHoldingList().getStockHoldingList().size());

        // test getStock
        Assertions.assertEquals(10, securityAccount.hasStock("AAPL"));

        // sell stocks
        double sellResult;
        StockMarket.getInstance().getStock("AAPL").setPrice(200);
        sellResult = securityAccount.sellStock("AAPL", 5);
        Assertions.assertEquals(500, sellResult);
        Assertions.assertEquals(6000, securityAccount.getBalance().get());
        sellResult = securityAccount.sellStock("AAPL", 10);
        Assertions.assertEquals(5, securityAccount.hasStock("AAPL"));
        Assertions.assertEquals(0, sellResult);
        Assertions.assertEquals(6000, securityAccount.getBalance().get());

        // simulate the price change
        StockMarket.getInstance().getStock("GOOG").setPrice(100);
        sellResult = securityAccount.sellStock("GOOG", 25);
        Assertions.assertEquals(-4000, sellResult);
        Assertions.assertEquals(8500, securityAccount.getBalance().get());
        StockMarket.getInstance().getStock("GOOG").setPrice(1000);
        sellResult = securityAccount.sellStock("GOOG", 5);

        Assertions.assertEquals(13500, securityAccount.getBalance().get());

        StockMarket.getInstance().getStock("MSFT").setPrice(100);
        Assertions.assertEquals(2000, securityAccount.getStockHoldingList().getTotalValue());

    }
}
