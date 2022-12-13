/*
 * Security Account is for stock trading
 */
package fancybank.account;

public class SecurityAccount extends Account {
    private StockHoldingList stockHoldingList = new StockHoldingList();

    public SecurityAccount() {
        super(0, "security", 0);
    }

    public SecurityAccount(int accountNumber) {
        super(accountNumber, "security", 0);
    }

    public SecurityAccount(int accountNumber, double balance) {
        super(accountNumber, "security", balance);
    }

    public StockHoldingList getStockHoldingList() {
        return stockHoldingList;
    }

}
