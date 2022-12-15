package fancybank.data.Handlers;

import fancybank.user.Address;
import fancybank.user.Customer;
import fancybank.user.Email;
import fancybank.user.Name;
import fancybank.user.Password;
import fancybank.user.UID;

/**
 * @author Haodong Chen hjc5283@bu.edu
 * Class for maintaining the customers' list. 
 */
public class CustomerHandler implements ArrayAppend<Customer> {

    private Customer[] customers;

    public CustomerHandler() {
        customers = new Customer[0];
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public Customer addCustomer(Name name, Address address, Email email, Password password) {
        int maxId = -1;
        for(Customer c: customers) {
            maxId = (c.getUID().get() > maxId ? c.getUID().get() : maxId);
        }
        Customer customerNew = new Customer(new UID(maxId + 1), name, address, email, password);
        customers = addElement(customers, customerNew);
        return customerNew;
    }
    
}
