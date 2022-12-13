/*
 * Security Account is for stock trading
 */
package fancybank.account;

import java.util.ArrayList;

import fancybank.stock.StockHolding;

public class SecurityAccount extends Account {
    private ArrayList<StockHolding> stockList;

    public SecurityAccount() {
        super(0, "Security");
        stockList = new ArrayList<StockHolding>();
    }

    public SecurityAccount(int accountNumber) {
        super(accountNumber, "Security");
        stockList = new ArrayList<StockHolding>();
    }

    public SecurityAccount(int accountNumber, double balance) {
        super(accountNumber, "Security");
        stockList = new ArrayList<StockHolding>();
        setBalance(balance);
    }

    public ArrayList<StockHolding> getStockList() {
        return stockList;
    }

}
