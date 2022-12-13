package fancybank.user;

import org.junit.jupiter.api.Test;

import fancybank.account.Account;
import fancybank.account.CheckAccount;
import fancybank.account.SavingAccount;
import fancybank.account.SecurityAccount;

import org.junit.jupiter.api.Assertions;

public class CustomerTest {
    @Test
    public void TestCustomerBasic() {
//@formatter:off
        Customer customer1 = new Customer(
            new UID(100001),
            new Name("Albert", "J", "Williams"),
            new Address("123 Commonwealth St", "Anytown", "MA", "02215", "USA"),
            new Email("albertwilliams@gmail.com"),
            new Password("12345678")
        );
//@formatter:on
        Assertions.assertEquals(customer1.getUID().get(), 100001);
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
}
