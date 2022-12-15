package fancybank.currency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrencyTest {
    @Test
    public void TestCurrency() {
        Currency currency1 = new Currency("USD", "$", 1.0);
        Assertions.assertEquals("USD", currency1.getName());
        Assertions.assertEquals("$", currency1.getSymbol());
        Assertions.assertEquals(1.0, currency1.getRate());

        Currency currency2 = new Currency("EUR", "€", 0.9);
        Assertions.assertEquals("EUR", currency2.getName());
        Assertions.assertEquals("€", currency2.getSymbol());
        Assertions.assertEquals(0.9, currency2.getRate());

        Currency currency3 = new Currency("EUR", "€", 1.1);
        Assertions.assertFalse(currency1.equals(currency3));
        Assertions.assertTrue(currency2.equals(currency3));
    }

    @Test
    public void TestCurrencyFactory() {
        Currency c1 = CurrencyFactory.getInstance().getCurrency("CNY");
        Assertions.assertEquals("CNY", c1.getName());
        Assertions.assertEquals("¥", c1.getSymbol());

        CurrencyFactory.getInstance().updateCurrencyRate("CNY", 6);
        Assertions.assertEquals(6, CurrencyFactory.getInstance().getCurrency("CNY").getRate());
    }
}
