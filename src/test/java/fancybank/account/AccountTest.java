package fancybank.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void TestCheckAccount() {
        // Test accout name
        CheckAccount checkAccount1 = new CheckAccount(10001);
        Assertions.assertEquals(10001, checkAccount1.getAccountNumber());
        Assertions.assertEquals(0, checkAccount1.getBalance());

        CheckAccount checkAccount2 = new CheckAccount(10002, -100);
        Assertions.assertEquals(10002, checkAccount2.getAccountNumber());
        Assertions.assertEquals(0, checkAccount2.getBalance());

        CheckAccount checkAccount3 = new CheckAccount(10003, 200);
        Assertions.assertEquals(10003, checkAccount3.getAccountNumber());
        Assertions.assertEquals(200, checkAccount3.getBalance());

        CheckAccount checkAccount4 = new CheckAccount(10004, 300);
        Assertions.assertEquals(300, checkAccount4.getBalance());
        checkAccount4.setBalance(400);
        Assertions.assertEquals(400, checkAccount4.getBalance());
        checkAccount4.setBalance(-500);
        Assertions.assertEquals(400, checkAccount4.getBalance());

        Account checkAccount5 = new CheckAccount(10004);
        Assertions.assertTrue(checkAccount5 instanceof CheckAccount);
    }

    @Test
    public void TestSavingAccouunt() {
        SavingAccount savingAccount1 = new SavingAccount(10001);
        Assertions.assertEquals(10001, savingAccount1.getAccountNumber());
        Assertions.assertEquals(0, savingAccount1.getBalance());
        savingAccount1.setBalance(100);
        Assertions.assertEquals(100, savingAccount1.getBalance());
        savingAccount1.setBalance(-200);
        Assertions.assertEquals(100, savingAccount1.getBalance());

        Account savingAccount2 = new SavingAccount(10002, 200);
        Assertions.assertTrue(savingAccount2 instanceof SavingAccount);
    }
}
