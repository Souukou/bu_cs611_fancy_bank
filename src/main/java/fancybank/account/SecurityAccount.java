/*
 * Security Account is for stock trading
 */
package fancybank.account;

public class SecurityAccount extends Account implements Transferable {
    private StockHoldingList stockHoldingList = new StockHoldingList();

    public SecurityAccount() {
        super(0, "security", 0, "USD");
    }

    public SecurityAccount(int accountNumber) {
        super(accountNumber, "security", 0, "USD");
    }

    // we only allow USD for stock account
    public SecurityAccount(int accountNumber, double balance) {
        super(accountNumber, "security", balance, "USD");
    }

    public StockHoldingList getStockHoldingList() {
        return stockHoldingList;
    }

    public void setStockHoldingList(StockHoldingList stockHoldingList) {
        this.stockHoldingList = stockHoldingList;
    }

    @Override
    public void transferTo(Account target, double amount) {
        if (amount < 0) {
            return;
        }
        if (!getBalance().isSufficient(amount)) {
            return;
        }
        getBalance().subtract(amount);
        target.getBalance().add(amount);
    }
}
