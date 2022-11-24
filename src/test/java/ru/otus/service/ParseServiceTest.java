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
        final String rubs = "рубля";
        final String usdl = "доллара";

        var rubWithWord = parseService.currencyNameDeclination(CurrencyEnum.RUB, 1L);
        var twoRubWithWord = parseService.currencyNameDeclination(CurrencyEnum.RUB, 2L);
        var usdlWithWord2 = parseService.currencyNameDeclination(CurrencyEnum.USD, 2L);

        assertEquals(rubWithWord, "один " + rub);
        assertEquals(twoRubWithWord, "два " + rubs);
        assertEquals(usdlWithWord2, "два " + usdl);
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

    @Test
    void shouldConvertNumberToStringRepresentation() {
        var oneResult = parseService.convertNumberToStringRepresentation(1);
        var twentyResult = parseService.convertNumberToStringRepresentation(12);
        var oneTwoZeroResult = parseService.convertNumberToStringRepresentation(122);
        var oneAndThreeTwoResult = parseService.convertNumberToStringRepresentation(1_222);
        var oneAndFourTwoResult = parseService.convertNumberToStringRepresentation(12_222);
        var oneAndFiveTwoResult = parseService.convertNumberToStringRepresentation(122_222);
        var oneAndSixTwoResult = parseService.convertNumberToStringRepresentation(1_222_222);
        var oneAndSevenTwoResult = parseService.convertNumberToStringRepresentation(12_222_222);
        var oneAndEightTwoResult = parseService.convertNumberToStringRepresentation(122_222_222);
        var oneAndNineTwoResult = parseService.convertNumberToStringRepresentation(1_222_222_222);
        var oneAndTenTwoResult = parseService.convertNumberToStringRepresentation(12_222_222_222L);
        var oneAndElevenTwoResult = parseService.convertNumberToStringRepresentation(122_222_222_222L);
        var oneAndTwelveTwoResult = parseService.convertNumberToStringRepresentation(1_222_222_222_222L);

        assertEquals("один ", oneResult);
        assertEquals("двенадцать ", twentyResult);
        assertEquals("сто двадцать два ", oneTwoZeroResult);
        assertEquals("одна тысяча двести двадцать два ", oneAndThreeTwoResult);
        assertEquals("двенадцать тысяч двести двадцать два ", oneAndFourTwoResult);
        assertEquals("сто двадцать две тысячи двести двадцать два ", oneAndFiveTwoResult);
        assertEquals("один миллион двести двадцать две тысячи двести двадцать два ", oneAndSixTwoResult);
        assertEquals("двенадцать миллионов двести двадцать две тысячи двести двадцать два ", oneAndSevenTwoResult);
        assertEquals("сто двадцать два миллиона двести двадцать две тысячи двести двадцать два ", oneAndEightTwoResult);
        assertEquals("один миллиард двести двадцать два миллиона двести двадцать две тысячи двести двадцать два ", oneAndNineTwoResult);
        assertEquals("двенадцать миллиардов двести двадцать два миллиона двести двадцать две тысячи двести двадцать два ", oneAndTenTwoResult);
        assertEquals("сто двадцать два миллиарда двести двадцать два миллиона двести двадцать две тысячи двести двадцать два ", oneAndElevenTwoResult);
        assertEquals("один триллион двести двадцать два миллиарда двести двадцать два миллиона двести двадцать две тысячи двести двадцать два ", oneAndTwelveTwoResult);
    }

}
