package fancybank.currency;

public class Currency {
    private String name;
    private String symbol;
    private double rate;

    public Currency(String name, String symbol, double rate) {
        this.name = name;
        this.symbol = symbol;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getRate() {
        return rate;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Currency) {
            Currency currency = (Currency) obj;
            return this.name.equals(currency.getName());
        }
        return false;
    }
}
