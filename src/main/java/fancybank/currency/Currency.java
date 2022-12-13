package fancybank.currency;

public class Currency {
    private String name;
    private String symbol;
    private double rateToUSD;

    public Currency(String name, String symbol, double rateToUSD) {
        this.name = name;
        this.symbol = symbol;
        this.rateToUSD = rateToUSD;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getRateToUSD() {
        return rateToUSD;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Currency) {
            Currency currency = (Currency) obj;
            return this.name.equals(currency.getName());
        }
        return false;
    }
}
