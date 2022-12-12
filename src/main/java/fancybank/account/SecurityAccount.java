/*
 * Security Account is for stock trading
 */
package fancybank.account;

// import java.util.ArrayList;

public class SecurityAccount extends Account {
    // private ArrayList<Stock> stocks;

    public SecurityAccount() {
        super(0, "Security");
        // stocks = new ArrayList<Stock>();
    }

    public SecurityAccount(int accountNumber) {
        super(accountNumber, "Security");
        // stocks = new ArrayList<Stock>();
    }

    public SecurityAccount(int accountNumber, double balance) {
        super(accountNumber, "Security");
        // stocks = new ArrayList<Stock>();
        setBalance(balance);
    }

}
