package fancybank.data.Handlers;

import java.util.ArrayList;

import fancybank.currency.Currency;

public class CurrencyHandler {

    ArrayList<Currency> currencies;

    public CurrencyHandler() {
        currencies = new ArrayList<Currency>();
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<Currency> currencies) {
        this.currencies = currencies;
    }

}
