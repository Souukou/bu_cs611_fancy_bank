package fancybank.user;

import org.junit.jupiter.api.Test;

import fancybank.account.Account;
import fancybank.account.Balance;
import fancybank.account.CheckAccount;
import fancybank.account.SavingAccount;
import fancybank.account.SecurityAccount;
import fancybank.bank.Bank;
import fancybank.currency.CurrencyFactory;
import fancybank.loan.Collateral;
import fancybank.loan.Loan;

import org.junit.jupiter.api.Assertions;

public class CustomerTest {
    @Test
    public void TestCustomerBasic() {
//@formatter:off
        Customer customer1 = new Customer(
            new UID(100001),
            new Username("albertwilliams"),
            new Name("Albert", "J", "Williams"),
            new Address("123 Commonwealth St", "Anytown", "MA", "02215", "USA"),
            new Email("albertwilliams@gmail.com"),
            new Password("12345678")
        );
//@formatter:on
        Assertions.assertEquals(customer1.getUID().get(), 100001);
        Assertions.assertEquals(customer1.getUsername().get(), "albertwilliams");
        Assertions.assertEquals(customer1.getName().getFirstName(), "Albert");
        Assertions.assertEquals(customer1.getName().getMiddleName(), "J");
        Assertions.assertEquals(customer1.getName().getLastName(), "Williams");
        Assertions.assertEquals(customer1.getAddress().getStreet(), "123 Commonwealth St");
        Assertions.assertEquals(customer1.getAddress().getCity(), "Anytown");
        Assertions.assertEquals(customer1.getAddress().getState(), "MA");
        Assertions.assertEquals(customer1.getAddress().getZip(), "02215");
        Assertions.assertEquals(customer1.getAddress().getCountry(), "USA");
        Assertions.assertEquals(customer1.getEmail().get(), "albertwilliams@gmail.com");
        Assertions.assertTrue(customer1.getPassword().validate("12345678"));
        Assertions.assertFalse(customer1.getPassword().validate("123456"));
        Assertions.assertEquals(0, customer1.getAccounts().size());

        customer1.createAccount("checking", 0, "USD");
        Assertions.assertEquals(1, customer1.getAccounts().size());
        Account curAccount = customer1.getAccounts().get(0);
        Assertions.assertTrue(curAccount instanceof CheckAccount);
        Assertions.assertEquals("checking", curAccount.getAccountType());
        Assertions.assertEquals(0, curAccount.getBalance().get());
        CheckAccount curCheckAccount = (CheckAccount) curAccount;
        curCheckAccount.deposit(1000);
        Assertions.assertEquals(1000, curCheckAccount.getBalance().get());
        curCheckAccount.withdraw(100);
        Assertions.assertEquals(900, curCheckAccount.getBalance().get());

        customer1.createAccount("saving", 0, "USD");
        Assertions.assertEquals(1, customer1.getSavingAccount().size());
        Assertions.assertEquals(1, customer1.getSavingAccount().size());
        SavingAccount curSavingAccount = customer1.getSavingAccount().get(0);
        curSavingAccount.deposit(50);
        Assertions.assertEquals(50, curSavingAccount.getBalance().get());

        customer1.createAccount("security", 0, "USD");
        Assertions.assertEquals(3, customer1.getAccounts().size());
        SecurityAccount securityAccount = customer1.getOneSecurityAccount();
        Assertions.assertEquals(0, securityAccount.getBalance().get());

        curCheckAccount.transferTo(securityAccount, 100);
        Assertions.assertEquals(800, curCheckAccount.getBalance().get());
        Assertions.assertEquals(100, securityAccount.getBalance().get());

        customer1.Transfer(curSavingAccount, securityAccount, 200); // will failed
        Assertions.assertEquals(50, curSavingAccount.getBalance().get());
        Assertions.assertEquals(100, securityAccount.getBalance().get());

        customer1.Transfer(curSavingAccount, securityAccount, 50, "to stock"); // will success
        Assertions.assertEquals(0, curSavingAccount.getBalance().get());
        Assertions.assertEquals(150, securityAccount.getBalance().get());

    }

    @Test
    public void TestCustomerExchangeCurrency() {
        Customer customer1 = new Customer(
                100001, "albertwilliams", "Albert", "J", "Williams", "123 Commonwealth St", "Anytown", "MA", "02215",
                "USA", "a@b.com", "xxxxxxxx");

        customer1.createAccount("checking", 0, "USD");
        customer1.createAccount("checking", 0, "CNY");
        customer1.createAccount("checking", 0, "EUR");

        CurrencyFactory.getInstance().updateCurrencyRate("CNY", 7);

        CheckAccount curUSDAccount = (CheckAccount) customer1.getOneAccountByCurrency("USD");
        Assertions.assertEquals(0, curUSDAccount.getBalance().get());
        CheckAccount curCNYAccount = (CheckAccount) customer1.getAccountByCurrency("CNY").get(0);
        Assertions.assertEquals(0, curCNYAccount.getBalance().get());
        CheckAccount curEURAccount = (CheckAccount) customer1.getAccountByCurrency("EUR").get(0);
        Assertions.assertEquals(0, curEURAccount.getBalance().get());

        curUSDAccount.deposit(1000);

        customer1.ExchangeCurrency(curUSDAccount, curCNYAccount, new Balance(100, "USD"));
        Assertions.assertEquals(900, curUSDAccount.getBalance().get());
        Assertions.assertEquals(700, curCNYAccount.getBalance().get());

        customer1.ExchangeCurrency(curUSDAccount, curCNYAccount, new Balance(700, "CNY"));
        Assertions.assertEquals(800, curUSDAccount.getBalance().get());
        Assertions.assertEquals(1400, curCNYAccount.getBalance().get());

        customer1.ExchangeCurrency(curCNYAccount, curEURAccount, new Balance(700, "CNY"));
        Assertions.assertEquals(700, curCNYAccount.getBalance().get());
        Assertions.assertEquals(90, curEURAccount.getBalance().get());

        customer1.ExchangeCurrency(curCNYAccount, curEURAccount, new Balance(45, "EUR"));
        Assertions.assertEquals(350, curCNYAccount.getBalance().get());
        Assertions.assertEquals(135, curEURAccount.getBalance().get());

        // the Balance Currency is NOT required to be same as to or from account
        customer1.ExchangeCurrency(curCNYAccount, curEURAccount, new Balance(50, "USD"));
        Assertions.assertEquals(0, curCNYAccount.getBalance().get());
        Assertions.assertEquals(180, curEURAccount.getBalance().get());
    }

    @Test
    public void TestLoan() {
        Customer customer = Bank.getInstance().Register(
                "albertwilliams", "Albert", "J", "Williams", "123 Commonwealth St", "Anytown", "MA", "02215",
                "USA", "a@b.com", "xxxxxxxx");
        customer.createAccount("checking", 0, "USD");
        Account acc = customer.getCheckAccount().get(0);
        Assertions.assertEquals(0, customer.getLoans().size());
        customer.makeLoan(acc, 10000, new Collateral("Car", 20000, "/path/to/car"));
        Assertions.assertEquals(1, customer.getLoans().size());
        Loan loan = customer.getLoans().get(0);
        loan.approve();
        Assertions.assertTrue(loan.isApproved());
        Assertions.assertEquals(10000, loan.getUnpaidAmount());
        Assertions.assertEquals(10000, acc.getBalance().get());
        loan.pay(5000);
        Assertions.assertEquals(5000, loan.getUnpaidAmount());
        loan.pay(5000);
        Assertions.assertEquals(0, loan.getUnpaidAmount());
        Assertions.assertTrue(loan.isPaidFully());
    }
}
