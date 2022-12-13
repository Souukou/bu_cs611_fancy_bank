package fancybank.data;

import java.util.ArrayList;

import fancybank.account.Account;
import fancybank.account.Balance;
import fancybank.currency.Currency;
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


}
