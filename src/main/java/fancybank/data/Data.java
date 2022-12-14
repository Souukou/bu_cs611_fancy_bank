package fancybank.data;

import java.util.ArrayList;

import fancybank.account.Account;
import fancybank.account.Balance;
import fancybank.currency.Currency;
import fancybank.stock.Stock;
import fancybank.user.Customer;

public class Data {
    public static Data instance = new Data();

    private Data() {
    }

    public static Data getInstance() {
        return instance;
    }

    private int TEMP_accountNumber = 10001; /// test only. should be read from db

    public int getMaxAccountNumber() {
        TEMP_accountNumber += 15; /// test only
        return TEMP_accountNumber;
    }

    public void saveAccount(Customer cos, Account accont) {
    }

    public void AddTransaction(Account from, Account to, double amount, String memo) {

    }

    public void AddTransaction(Account from, Account to, Balance amount, String memo) {

    }

    public ArrayList<Currency> getCurrencyList() {
        // read currency from db
        ArrayList<Currency> currencyList = new ArrayList<Currency>();
        currencyList.add(new Currency("USD", "$", 1.0));
        currencyList.add(new Currency("EUR", "€", 0.9));
        currencyList.add(new Currency("JPY", "¥", 110.0));
        currencyList.add(new Currency("GBP", "£", 0.8));
        currencyList.add(new Currency("AUD", "$", 1.4));
        currencyList.add(new Currency("CAD", "$", 1.3));
        currencyList.add(new Currency("CHF", "Fr", 1.0));
        currencyList.add(new Currency("CNY", "¥", 7.0));
        currencyList.add(new Currency("HKD", "$", 7.8));
        currencyList.add(new Currency("NZD", "$", 1.5));
        currencyList.add(new Currency("SEK", "kr", 9.0));
        currencyList.add(new Currency("SGD", "$", 1.4));
        currencyList.add(new Currency("KRW", "₩", 1200.0));
        currencyList.add(new Currency("MXN", "$", 20.0));
        currencyList.add(new Currency("NOK", "kr", 9.0));
        currencyList.add(new Currency("RUB", "₽", 70.0));
        currencyList.add(new Currency("INR", "₹", 70.0));
        currencyList.add(new Currency("ZAR", "R", 14.0));
        currencyList.add(new Currency("TRY", "₺", 6.0));
        currencyList.add(new Currency("BRL", "R$", 4.0));
        currencyList.add(new Currency("TWD", "NT$", 30.0));
        currencyList.add(new Currency("MYR", "RM", 4.0));
        currencyList.add(new Currency("PHP", "₱", 50.0));
        currencyList.add(new Currency("IDR", "Rp", 14000.0));
        currencyList.add(new Currency("THB", "฿", 30.0));
        currencyList.add(new Currency("VND", "₫", 23000.0));
        currencyList.add(new Currency("CZK", "Kč", 23.0));
        currencyList.add(new Currency("DKK", "kr", 6.5));
        currencyList.add(new Currency("HUF", "Ft", 300.0));
        currencyList.add(new Currency("PLN", "zł", 3.8));
        currencyList.add(new Currency("ILS", "₪", 3.5));
        return currencyList;
    }

    public ArrayList<Stock> getStockMarket() {
        // test only, need to retrive from db
        ArrayList<Stock> stockList = new ArrayList<Stock>();
        stockList.add(new Stock("AAPL", "Apple", 10.99));
        stockList.add(new Stock("GOOG", "Google", 18.88));
        stockList.add(new Stock("MSFT", "Microsoft", 20.05));
        stockList.add(new Stock("AMZN", "Amazon", 8.99));
        stockList.add(new Stock("FB", "Facebook", 400));
        stockList.add(new Stock("TSLA", "Tesla", 500));
        stockList.add(new Stock("NFLX", "Netflix", 600));
        stockList.add(new Stock("NVDA", "Nvidia", 700));
        stockList.add(new Stock("PYPL", "PayPal", 800));
        stockList.add(new Stock("INTC", "Intel", 900));
        stockList.add(new Stock("CSCO", "Cisco", 1000));
        stockList.add(new Stock("QCOM", "Qualcomm", 1100));
        stockList.add(new Stock("TXN", "Texas Instruments", 1200));
        stockList.add(new Stock("ADBE", "Adobe", 1300));
        stockList.add(new Stock("CRM", "Salesforce", 1400));
        stockList.add(new Stock("AVGO", "Broadcom", 1500));
        stockList.add(new Stock("COST", "Costco", 1600));
        stockList.add(new Stock("SBUX", "Starbucks", 1700));
        stockList.add(new Stock("CMCSA", "Comcast", 1800));
        stockList.add(new Stock("AMGN", "Amgen", 1900));
        stockList.add(new Stock("CHTR", "Charter", 2000));
        stockList.add(new Stock("GILD", "Gilead", 2100));
        stockList.add(new Stock("MDLZ", "Mondelez", 2200));
        stockList.add(new Stock("ISRG", "Intuitive Surgical", 2300));
        stockList.add(new Stock("TMUS", "T-Mobile", 2400));
        stockList.add(new Stock("AMAT", "Applied Materials", 2500));
        stockList.add(new Stock("AMD", "AMD", 2600));
        stockList.add(new Stock("MU", "Micron", 2700));
        return stockList;
    }

    public void saveStockMarket(ArrayList<Stock> stockList) {
        // test only, need to save to db
    }


}
