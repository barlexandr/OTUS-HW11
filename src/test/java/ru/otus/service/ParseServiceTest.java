package ru.otus.service;

import org.junit.jupiter.api.Test;
import ru.otus.enums.CurrencyEnum;
import ru.otus.service.impl.ParseServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseServiceTest {

    private final ParseService parseService = new ParseServiceImpl();

    @Test
    void shouldCurrencyNameDeclination() {
        final String rub = "рубль";
        final String usdl = "доллара";

        var rubWithWord = parseService.currencyNameDeclination(CurrencyEnum.RUB, 1L);
        var usdlWithWord2 = parseService.currencyNameDeclination(CurrencyEnum.USD, 2L);

        assertEquals(rubWithWord, "1 " + rub);
        assertEquals(usdlWithWord2, "2 " + usdl);
    }

    @Test
    void shouldDeclinationOnRubles() {
        final String rub = "рубль";
        final String rubl = "рубля";
        final String rubles = "рублей";

        var rubWithWord = parseService.declinationOnRubles(1L);
        var rublWithWord2 = parseService.declinationOnRubles(2L);
        var rublWithWord3 = parseService.declinationOnRubles(3L);
        var rublWithWord4 = parseService.declinationOnRubles(4L);
        var rublesWithWord = parseService.declinationOnRubles(0L);
        var rublesWithWord8 = parseService.declinationOnRubles(8L);

        assertEquals(rubWithWord, rub);
        assertEquals(rublWithWord2, rubl);
        assertEquals(rublWithWord3, rubl);
        assertEquals(rublWithWord4, rubl);
        assertEquals(rublesWithWord, rubles);
        assertEquals(rublesWithWord8, rubles);
    }

    @Test
    void shouldDeclinationOnUSD() {
        final String usd = "доллар";
        final String usdl = "доллара";
        final String usds = "долларов";

        var usdWithWord = parseService.declinationOnUSD(1L);
        var usdlWithWord2 = parseService.declinationOnUSD(2L);
        var usdlWithWord3 = parseService.declinationOnUSD(3L);
        var usdlWithWord4 = parseService.declinationOnUSD(4L);
        var usdlesWithWord = parseService.declinationOnUSD(0L);
        var usdsWithWord8 = parseService.declinationOnUSD(8L);

        assertEquals(usdWithWord, usd);
        assertEquals(usdlWithWord2, usdl);
        assertEquals(usdlWithWord3, usdl);
        assertEquals(usdlWithWord4, usdl);
        assertEquals(usdlesWithWord, usds);
        assertEquals(usdsWithWord8, usds);
    }

}
