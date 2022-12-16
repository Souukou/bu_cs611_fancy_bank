/*
 * Transaction happened when buy/sell stocks.
 */

package fancybank.transaction;

import fancybank.account.Money;

public class StockTransaction extends Transaction {

    private String stock;

    public StockTransaction(int from, int to, Money money, String stockSymbol) {
        super(from, to, money, TransactionType.STOCK);
        this.stock = stockSymbol;
    }

    public String getSymbol() {
        return stock;
    }
    
}
