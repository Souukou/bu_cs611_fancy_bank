package fancybank.user;

import org.junit.jupiter.api.Test;
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
    }
}
