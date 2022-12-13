package fancybank.user;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserAttributeTest {
    @Test
    public void testUID() {
        UID uid = new UID();
        Assertions.assertEquals(0, uid.get());
        uid.set(1);
        Assertions.assertEquals(1, uid.get());
        uid.set(-1);
        Assertions.assertEquals(1, uid.get());
    }

    @Test
    public void testPassword() {
        Password password = new Password();

        Assertions.assertFalse(password.checkPassword("xxx"));
        password.set("abc123456??");
        Assertions.assertTrue(password.validate("abc123456??"));
        Assertions.assertFalse(password.validate("abc123456"));

    }

}
