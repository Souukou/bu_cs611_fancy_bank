package fancybank.currency;

import java.util.ArrayList;

import fancybank.data.Data;

public class CurrencyFactory {
    private static CurrencyFactory instance;

    public static CurrencyFactory getInstance() {
        if (instance == null) {
            ArrayList<Currency> currencyList = Data.getInstance().getCurrencyList();
            instance = new CurrencyFactory(currencyList);
        }
        return instance;
    }

    private ArrayList<Currency> currencyList;

    public CurrencyFactory(ArrayList<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    private void save() {
        Data.getInstance().updateCurrencyList(currencyList);
    }

    public Currency getCurrency(String name) {
        for (Currency currency : currencyList) {
            if (currency.getName().equals(name)) {
                return currency;
            }
        }
        return null;
    }

    public ArrayList<Currency> getCurrencyList() {
        return currencyList;
    }

    public boolean hasCurrency(String name) {
        for (Currency currency : currencyList) {
            if (currency.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void addCurrency(String name, String symbol, double rate) {
        if (!hasCurrency(name)) {
            Currency currency = new Currency(name, symbol, rate);
            currencyList.add(currency);
            save();
        }
    }

    public void removeCurrency(String symbol) {
        for (Currency currency : currencyList) {
            if (currency.getSymbol().equals(symbol)) {
                currencyList.remove(currency);
                save();
                break;
            }
        }
    }

    public void updateCurrencyRate(String symbol, double rate) {
        for (Currency currency : currencyList) {
            if (currency.getSymbol().equals(symbol)) {
                currency.setRate(rate);
                save();
                break;
            }
        }
    }

}
