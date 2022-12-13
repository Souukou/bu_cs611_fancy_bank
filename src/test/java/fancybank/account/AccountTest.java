package fancybank.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void TestCheckAccount() {
        // Test accout name
        CheckAccount checkAccount1 = new CheckAccount(10001);
        Assertions.assertEquals(10001, checkAccount1.getAccountNumber());
        Assertions.assertEquals(0.00, checkAccount1.getBalance().get());

        CheckAccount checkAccount2 = new CheckAccount(10002, -100);
        Assertions.assertEquals(10002, checkAccount2.getAccountNumber());
        Assertions.assertEquals(0, checkAccount2.getBalance().get());

        CheckAccount checkAccount3 = new CheckAccount(10003, 200);
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

        SavingAccount savingAccount2 = new SavingAccount(10002, 200);
        Assertions.assertEquals(200, savingAccount2.getBalance().get());

        Account savingAccount3 = new SavingAccount(10002, 200);
        Assertions.assertTrue(savingAccount3 instanceof SavingAccount);
    }

    @Test
    public void TestAccountTransfer() {
        SavingAccount savingAccount1 = new SavingAccount(10001, 10000);
        CheckAccount checkAccount1 = new CheckAccount(10002, 100);
        savingAccount1.transferTo(checkAccount1, 100);
        Assertions.assertEquals(9900, savingAccount1.getBalance().get());
        Assertions.assertEquals(200, checkAccount1.getBalance().get());

        // insufficient balance, do nothing
        savingAccount1.transferTo(checkAccount1, 10000);
        Assertions.assertEquals(9900, savingAccount1.getBalance().get());
        Assertions.assertEquals(200, checkAccount1.getBalance().get());

    }
}
