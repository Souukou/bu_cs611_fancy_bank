package fancybank.data.Handlers;

import fancybank.currency.Currency;

public class CurrencyHandler implements ArrayAppend<Currency> {

    Currency[] currencies;

    public CurrencyHandler() {
        currencies = new Currency[0];
    }

    public Currency[] getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Currency[] currencies) {
        this.currencies = currencies;
    }

    public void addCurrency(Currency currency) {
        currencies = addElement(currencies, currency);
    }

}
