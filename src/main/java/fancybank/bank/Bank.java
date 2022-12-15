package fancybank.bank;

import fancybank.data.Data;
import fancybank.user.Address;
import fancybank.user.Customer;
import fancybank.user.Email;
import fancybank.user.Manager;
import fancybank.user.Name;
import fancybank.user.Password;
import fancybank.user.Username;

public class Bank {
    private static Bank instance;

    public static Bank getInstance() {
        if (instance == null)
            instance = Data.getInstance().getBank();
        return instance;
    }

    public void save() {
        Data.getInstance().updateBank(instance);
    }

    private double savingInterestRate;
    private double loanInterestRate;

    public double getSavingsInterestRate() {
        return savingInterestRate;
    }

    public double getLoanInterestRate() {
        return loanInterestRate;
    }

    public void setSavingsInterestRate(double savingInterestRate) {
        this.savingInterestRate = savingInterestRate;
        this.save();
    }

    public void setLoanInterestRate(double loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
        this.save();
    }

    public static Customer Login(String username, String password) {
        Customer customer = Data.getInstance().getCustomerByUsername(new Username(username), password);
        // return null if username or password is wrong
        return customer;
    }

    public static Customer Register(String username, String firstName, String middleName,
            String lastName, String street, String city, String state, String zip, String country, String email,
            String password) {
        Customer customer = Data.getInstance().addCustomer(new Username(username),
                new Name(firstName, middleName, lastName), new Address(street, city, state, zip, country),
                new Email(email), new Password(password));
        return customer;
    }

    public static Manager ManagerLogin(String username, String password) {
        Manager manager = Data.getInstance().getManagerByUsername(new Username(username), password);
        return manager;

    }

    // TODO
    public static Manager ManagerRegister(String username, String firstName, String middleName,
            String lastName, String street, String city, String state, String zip, String country, String email,
            String password) {
        Manager manager = Data.getInstance().addManager(new Username(username),
                new Name(firstName, middleName, lastName), new Address(street, city, state, zip, country),
                new Email(email), new Password(password));
        return manager;
    }
}
