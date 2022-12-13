package fancybank.bank;

import fancybank.data.Data;
import fancybank.user.Customer;

public class Bank {
    public static Customer Login(String email, String password) {
        Customer customer = Data.getInstance().getCustomerByEmail(email);
        if (customer == null) {
            return null;
        }
        if (!customer.getPassword().validate(password)) {
            return null;
        }
        return customer;
    }

    public static Customer Register(String firstName, String middleName, String lastName, String street, String city, String state, String zip, String country, String email, String password) {
        int UID = Data.getInstance().getMaxUID() + 1;
        Customer customer = new Customer(UID, firstName, middleName, lastName, street, city, state, zip, country, email, password);
        Data.getInstance().saveCustomer(customer);
        return customer;
    }
}
