package fancybank.account;

import fancybank.stock.Stock;

public interface Tradable {
    public boolean buyStock(Stock stock, int quantity);

    public boolean buyStock(String symbol, int quantity);

    public boolean sellStock(Stock stock, int quantity);

    public boolean sellStock(String symbol, int quantity);
}
