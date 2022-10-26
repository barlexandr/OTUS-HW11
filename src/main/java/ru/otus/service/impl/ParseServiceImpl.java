package ru.otus.service.impl;

import ru.otus.service.ParseService;
import ru.otus.enums.CurrencyEnum;

public class ParseServiceImpl implements ParseService {

    @Override
    public String currencyNameDeclination(CurrencyEnum currencyName, long value) {
        if (value != 0) {
            switch (currencyName) {
                case RUB -> {
                    var currencyInTheRightCase = declinationOnRubles(value);
                    return value + " " + currencyInTheRightCase;
                }
                case USD -> {
                    var currencyInTheRightCase = declinationOnUSD(value);
                    return value + " " + currencyInTheRightCase;
                }
                default -> {
                    return "You specified an unsupported currency";
                }
            }
        } else {
            return "";
        }
    }

    @Override
    public String declinationOnRubles(long value) {
        var lastDigit = (int) (value % 10);

        return switch (lastDigit) {
            case 1 -> "рубль";
            case 2, 3, 4 -> "рубля";
            default -> "рублей";
        };
    }

    @Override
    public String declinationOnUSD(long value) {
        var lastDigit = (int) value % 10;

        return switch (lastDigit) {
            case 1 -> "доллар";
            case 2, 3, 4 -> "доллара";
            default -> "долларов";
        };
    }
}
