package fancybank.stock;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fancybank.account.StockHoldingList;

public class StockTest {

    @Test
    public void TestSingleStock() {
        Stock stock1 = new Stock("AAPL", "Apple", 100);
        Assertions.assertEquals("AAPL", stock1.getSymbol());
        Assertions.assertEquals("Apple", stock1.getName());
        Assertions.assertEquals(100, stock1.getPrice());
        stock1.setPrice(200);
        Assertions.assertEquals("AAPL", stock1.getSymbol());

        Stock stock2 = new Stock("GOOG", "Google", 1000);
        Assertions.assertEquals("GOOG", stock2.getSymbol());
        Assertions.assertEquals("Google", stock2.getName());
        Assertions.assertEquals(1000, stock2.getPrice());

        Stock stock3 = new Stock("MSFT", "Microsoft");
        Assertions.assertEquals("MSFT", stock3.getSymbol());
        Assertions.assertEquals("Microsoft", stock3.getName());
        Assertions.assertEquals(0, stock3.getPrice());
        // if stock symbol is same, it is same stock
        Assertions.assertTrue(stock3.equals(new Stock("MSFT", "Microsoft")));
        Assertions.assertTrue(stock3.equals(new Stock("MSFT")));
        Assertions.assertTrue(stock3.equals(new Stock("MSFT", "Microsoft", 0.99)));

        Stock stock4 = new Stock("AMZN");
        Assertions.assertEquals("AMZN", stock4.getSymbol());
        Assertions.assertEquals("", stock4.getName());
        Assertions.assertEquals(0, stock4.getPrice());
    }

    @Test
    public void TestStockMarket() {
        StockMarket market = new StockMarket();
        market.addStock(new Stock("AAPL", "Apple", 100));
        market.addStock(new Stock("GOOG", "Google", 1000));
        market.addStock(new Stock("MSFT", "Microsoft", 200));
        market.addStock(new Stock("AMZN", "Amazon", 3000));
        market.addStock(new Stock("FB", "Facebook", 400));
        market.addStock(new Stock("TSLA", "Tesla", 500));
        market.addStock(new Stock("NFLX", "Netflix", 600));
        market.addStock(new Stock("NVDA", "Nvidia", 700));
        market.addStock(new Stock("PYPL", "PayPal", 800));
        market.addStock(new Stock("INTC", "Intel", 900));
        market.addStock(new Stock("CSCO", "Cisco", 1000));
        market.addStock(new Stock("QCOM", "Qualcomm", 1100));
        market.addStock(new Stock("TXN", "Texas Instruments", 1200));
        market.addStock(new Stock("ADBE", "Adobe", 1300));
        market.addStock(new Stock("CRM", "Salesforce", 1400));
        market.addStock(new Stock("AVGO", "Broadcom", 1500));
        market.addStock(new Stock("COST", "Costco", 1600));
        market.addStock(new Stock("SBUX", "Starbucks", 1700));
        market.addStock(new Stock("CMCSA", "Comcast", 1800));
        market.addStock(new Stock("AMGN", "Amgen", 1900));
        market.addStock(new Stock("CHTR", "Charter", 2000));
        market.addStock(new Stock("GILD", "Gilead", 2100));
        market.addStock(new Stock("MDLZ", "Mondelez", 2200));
        market.addStock(new Stock("ISRG", "Intuitive Surgical", 2300));
        market.addStock(new Stock("TMUS", "T-Mobile", 2400));
        market.addStock(new Stock("AMAT", "Applied Materials", 2500));
        market.addStock(new Stock("AMD", "AMD", 2600));
        market.addStock(new Stock("MU", "Micron", 2700));

        Assertions.assertEquals(28, market.size());

        // get stock by symbol
        Stock curStock = market.getStock("AAPL");
        Assertions.assertEquals("Apple", curStock.getName());
        Assertions.assertEquals(100, curStock.getPrice());

        // get non-exist stock
        curStock = market.getStock("AAP2");

        // test hasStock
        Assertions.assertFalse(market.hasStock("AAP2"));
        Assertions.assertTrue(market.hasStock("AAPL"));

        // add duplicate stock symbol
        market.addStock(new Stock("AAPL", "BadApple", 123));
        Assertions.assertEquals(28, market.size());

        // add duplicate stock name
        market.addStock(new Stock("AAP2", "Apple", 234));
        Assertions.assertEquals(28, market.size());

        // remove stock by symbol
        market.removeStock("MU");
        Assertions.assertEquals(27, market.size());

        // remove non-exist stock
        market.removeStock("MU");
        Assertions.assertEquals(27, market.size());

        // remove stock by stock object
        Assertions.assertTrue(market.hasStock(new Stock("AMAT", "Applied Materials", 10)));
        Assertions.assertTrue(market.removeStock(new Stock("AMAT", "Applied Materials", 10)));
        Assertions.assertEquals(26, market.size());
        market.removeStock(new Stock("GILD"));
        Assertions.assertEquals(25, market.size());

        // remove non-exist stock by stock object
        market.removeStock(new Stock("GILD"));
        Assertions.assertEquals(25, market.size());

        // change stock price
        curStock = market.getStock("AAPL");
        Assertions.assertNotNull(curStock);
        Assertions.assertEquals("Apple", curStock.getName());
        Assertions.assertEquals(100, curStock.getPrice());
        curStock.setPrice(200);
        Assertions.assertEquals(200, market.getStock("AAPL").getPrice());
    }

    @Test
    public void TestStockMarketPrint() {
        StockMarket market = new StockMarket();
        market.addStock(new Stock("AAPL", "Apple", 100));
        market.addStock(new Stock("GOOG", "Google", 1000));
        market.addStock(new Stock("MSFT", "Microsoft", 200));
        market.addStock(new Stock("AMZN", "Amazon", 3000));

    }

    @Test
    public void TestStockHolding() {
        // add APPL stock if not exist
        StockMarket.getInstance().addStock(new Stock("AAPL", "Apple", 10.99));
        StockMarket.getInstance().getStock("AAPL").setPrice(10.99);
        // pull the stock
        Stock curStock = StockMarket.getInstance().getStock("AAPL");
        double originalPrice = StockMarket.getInstance().getStock("AAPL").getPrice();
        // test holding
        StockHolding holding = new StockHolding(curStock, 100);
        Assertions.assertEquals("AAPL", holding.getStock().getSymbol());
        Assertions.assertEquals("Apple", holding.getStock().getName());
        Assertions.assertEquals(originalPrice, holding.getStock().getPrice());
        Assertions.assertEquals(100, holding.getQuantity());
        Assertions.assertEquals(100 * originalPrice, holding.getValue());
        // suppose stock price changed to 11.99
        curStock.setPrice(11.99);
        Assertions.assertEquals(11.99, holding.getStock().getPrice());
        Assertions.assertEquals(1199, holding.getValue());
        Assertions.assertEquals(10.99, holding.getBoughtPrice());
    }

    @Test
    public void TestStockHoldingList() {
        // add stock if not exist
        StockMarket.getInstance().addStock(new Stock("AAPL", "Apple", 10.99));
        StockMarket.getInstance().getStock("AAPL").setPrice(10.99);
        StockMarket.getInstance().addStock(new Stock("GOOG", "Google", 18.88));
        StockMarket.getInstance().getStock("GOOG").setPrice(18.88);
        // pull out the stock
        Stock appleStock = StockMarket.getInstance().getStock("AAPL");
        Stock googleStock = StockMarket.getInstance().getStock("GOOG");
        StockHoldingList holdingList = new StockHoldingList();
        Assertions.assertEquals(0, holdingList.size());

        holdingList.add(new StockHolding(appleStock, 100));
        Assertions.assertEquals(1, holdingList.size());

        holdingList.add(new StockHolding("AAPL", 2.55, 200));
        Assertions.assertEquals(2, holdingList.size());

        holdingList.add(new StockHolding(googleStock, 300));
        Assertions.assertEquals(3, holdingList.size());

        // find holdings by stock symbol
        Assertions.assertEquals(2, holdingList.getStockHoldingList("AAPL").size());
        Assertions.assertEquals(1, holdingList.getStockHoldingList("GOOG").size());

        // find holdings by stock object
        Assertions.assertEquals(2, holdingList.getStockHoldingList(appleStock).size());
        Assertions.assertEquals(1, holdingList.getStockHoldingList(googleStock).size());

        // test single holding price
        StockMarket.getInstance().getStock("AAPL").setPrice(20);
        ArrayList<StockHolding> appleHoldingList = holdingList.getStockHoldingList("AAPL");
        Assertions.assertEquals(2, appleHoldingList.size());
        Assertions.assertEquals(20 * 100, appleHoldingList.get(0).getValue());
        Assertions.assertEquals(20 * 200, appleHoldingList.get(1).getValue());

        // test total value
        Assertions.assertEquals(20 * 100 + 20 * 200 + 18.88 * 300, holdingList.getTotalValue());

        // roll back
        StockMarket.getInstance().getStock("AAPL").setPrice(10.99);
    }


}
