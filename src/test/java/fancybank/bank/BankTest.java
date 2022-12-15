package fancybank.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fancybank.data.Data;
import fancybank.user.Customer;
import fancybank.user.Manager;

public class BankTest {
    @Test
    public void TestCostomerLoginAndRegister() {
        Data.getInstance().getManagers().size();

        Bank.getInstance().ManagerRegister("admin", "Michael", "", "Jackson", "1601 Queens Road, Hollywood Hills",
                "Los Olivos", "California", "93441", "US", "mike@gmail.com", "12345678");

        Assertions.assertTrue(Data.getInstance().getManagers().size() >= 1);
        // wrong pass
        Manager m = Bank.getInstance().ManagerLogin("admin", "qwert");
        Assertions.assertNull(m);
        // wrong username
        m = Bank.getInstance().ManagerLogin("adminx", "12345678");
        Assertions.assertNull(m);
        // right
        m = Bank.getInstance().ManagerLogin("admin", "12345678");
        Assertions.assertNotNull(m);
        Assertions.assertEquals("Michael", m.getName().getFirstName());
        Assertions.assertEquals("Jackson", m.getName().getLastName());

        // // register again
        // m = Bank.getInstance().ManagerRegister("mmmmc", "Michael", "", "Jackson",
        // "1601 Queens Road, Hollywood Hills",
        // "Los Olivos", "California", "93441", "US", "mike@gmail.com", "qwert123");
        // Assertions.assertNull(m);
    }

    @Test
    public void TestCostomerLoginAndRegister_2() {

        Bank.getInstance().Register("jjjjjk", "Jack", "", "Ma", "123 some road",
                "Los Agles", "California", "90001", "US", "mike@gmail.com", "12345678");

        // wrong pass
        Customer m = Bank.getInstance().Login("jjjjjk", "qwert");
        Assertions.assertNull(m);
        // wrong username
        m = Bank.getInstance().Login("jjjjjkkkk", "12345678");
        Assertions.assertNull(m);
        // right
        m = Bank.getInstance().Login("jjjjjk", "12345678");
        Assertions.assertNotNull(m);
        Assertions.assertEquals("Jack", m.getName().getFirstName());
        Assertions.assertEquals("Ma", m.getName().getLastName());

    }
}
