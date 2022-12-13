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

}
