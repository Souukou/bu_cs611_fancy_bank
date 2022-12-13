package fancybank.stock;

import java.util.ArrayList;


public class StockMarket {

    public static StockMarket market;

    public static StockMarket getInstance() {
        if (market == null) {
            market = new StockMarket();
            // load all the stock data from DB
            market.addStock(new Stock("AAPL", "Apple", 10.99));
            market.addStock(new Stock("GOOG", "Google", 18.88));
            market.addStock(new Stock("MSFT", "Microsoft", 20.05));
            market.addStock(new Stock("AMZN", "Amazon", 8.99));
            market.addStock(new Stock("FB", "Facebook", 400));
            market.addStock(new Stock("TSLA", "Tesla", 500));
            market.addStock(new Stock("NFLX", "Netflix", 600));
            market.addStock(new Stock("NVDA", "Nvidia", 700));
            market.addStock(new Stock("PYPL", "PayPal", 800));
            market.addStock(new Stock("INTC", "Intel", 900));
            market.addStock(new Stock("CSCO", "Cisco", 1000));
            market.addStock(new Stock("QCOM", "Qualcomm", 1100));
            market.addStock(new Stock("TXN", "Texas Instruments", 1200));
            market.addStock(new Stock("ADBE", "Adobe", 1300));
            market.addStock(new Stock("CRM", "Salesforce", 1400));
            market.addStock(new Stock("AVGO", "Broadcom", 1500));
            market.addStock(new Stock("COST", "Costco", 1600));
            market.addStock(new Stock("SBUX", "Starbucks", 1700));
            market.addStock(new Stock("CMCSA", "Comcast", 1800));
            market.addStock(new Stock("AMGN", "Amgen", 1900));
            market.addStock(new Stock("CHTR", "Charter", 2000));
            market.addStock(new Stock("GILD", "Gilead", 2100));
            market.addStock(new Stock("MDLZ", "Mondelez", 2200));
            market.addStock(new Stock("ISRG", "Intuitive Surgical", 2300));
            market.addStock(new Stock("TMUS", "T-Mobile", 2400));
            market.addStock(new Stock("AMAT", "Applied Materials", 2500));
            market.addStock(new Stock("AMD", "AMD", 2600));
            market.addStock(new Stock("MU", "Micron", 2700));
        }
        return market;
    }

    private ArrayList<Stock> stockList;

    public StockMarket() {
        stockList = new ArrayList<Stock>();
    }

    public ArrayList<Stock> getStockList() {
        return stockList;
    }

    public boolean addStock(Stock stock) {
        // check if stock already exists
        for (Stock s : stockList) {
            if (s.getSymbol().equals(stock.getSymbol()) || s.getName().equals(stock.getName())) {
                return false;
            }
        }
        stockList.add(stock);
        return true;
    }

    public boolean hasStock(Stock stock) {
        return stockList.contains(stock);
    }

    public boolean hasStock(String symbol) {
        for (Stock stock : stockList) {
            if (stock.getSymbol().equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    public Stock getStock(String symbol) {
        for (Stock stock : stockList) {
            if (stock.getSymbol().equals(symbol)) {
                return stock;
            }
        }
        return null;
    }

    public int size() {
        return stockList.size();
    }

    public boolean removeStock(String symbol) {
        Stock theStock = getStock(symbol);
        if (theStock != null) {
            stockList.remove(theStock);
            return true;
        }
        return false;
    }

    public boolean removeStock(Stock stock) {
        if (hasStock(stock)) {
            stockList.remove(stock);
            return true;
        }
        return false;
    }


}
