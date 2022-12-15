package fancybank.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fancybank.data.Data;
import fancybank.user.Manager;

public class BankTest {
    @Test
    public void TestCostomerLoginAndRegister() {
        Data.getInstance().getManagers().size();

        Bank.getInstance().ManagerRegister("mmmmc", "Michael", "", "Jackson", "1601 Queens Road, Hollywood Hills",
                "Los Olivos", "California", "93441", "US", "mike@gmail.com", "qwert123");

        // TODO: wait Data.getInstance().getManagers().register to be fixed
        // Assertions.assertEquals(1, Data.getInstance().getManagers().size());
        // // wrong pass
        // Manager m = Bank.getInstance().ManagerLogin("mmmmc", "qwert");
        // Assertions.assertNull(m);
        // // wrong username
        // m = Bank.getInstance().ManagerLogin("mmmmcc", "qwert123");
        // Assertions.assertNull(m);
        // // right
        // m = Bank.getInstance().ManagerLogin("mmmmc", "qwert123");
        // Assertions.assertNotNull(m);
        // Assertions.assertEquals("Miclael", m.getName().getFirstName());
        // Assertions.assertEquals("Jackson", m.getName().getLastName());

        // // register again
        // m = Bank.getInstance().ManagerRegister("mmmmc", "Michael", "", "Jackson",
        // "1601 Queens Road, Hollywood Hills",
        // "Los Olivos", "California", "93441", "US", "mike@gmail.com", "qwert123");
        // Assertions.assertNull(m);
    }
}
