package ru.otus.service;

import ru.otus.enums.CurrencyEnum;

public interface ParseService {

    String currencyNameDeclination(CurrencyEnum currencyName, long value);

    String convertNumberToStringRepresentation(long value);

    String declinationOnRubles(long value);

    String declinationOnUSD(long value);
}
