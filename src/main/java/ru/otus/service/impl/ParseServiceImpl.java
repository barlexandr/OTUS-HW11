package ru.otus.service.impl;

import ru.otus.enums.CurrencyEnum;
import ru.otus.service.ParseService;

import java.util.ArrayList;
import java.util.Collections;

public class ParseServiceImpl implements ParseService {

    private final String[][] sex = {
            {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
    };
    private final String[] str100 = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private final String[] str11 = {"", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать", "двадцать"};
    private final String[] str10 = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private final String[][] forms = {
            {"тысяча", "тысячи", "тысяч", "1"},
            {"миллион", "миллиона", "миллионов", "0"},
            {"миллиард", "миллиарда", "миллиардов", "0"},
            {"триллион", "триллиона", "триллионов", "0"}
    };

    @Override
    public String currencyNameDeclination(CurrencyEnum currencyName, long value) {
        if (value != -1) {
            switch (currencyName) {
                case RUB -> {
                    var currencyInTheRightCase = declinationOnRubles(value);
                    return convertNumberToStringRepresentation(value) + currencyInTheRightCase;
                }
                case USD -> {
                    var currencyInTheRightCase = declinationOnUSD(value);
                    return convertNumberToStringRepresentation(value) + currencyInTheRightCase;
                }
                default -> {
                    return "You specified an unsupported currency";
                }
            }
        } else {
            return "";
        }
    }

    public String convertNumberToStringRepresentation(long value) {
        var sum = value;
        var segments = new ArrayList<Long>();
        while (sum > 999) {
            long seg = sum / 1000;
            segments.add(sum - (seg * 1000));
            sum = seg;
        }
        segments.add(sum);
        Collections.reverse(segments);
        StringBuilder stringBuilder = new StringBuilder();
        if (value == 0) {
            return "ноль";
        }

        int lev = segments.size() - 1;
        for (Long segment : segments) {
            int currentSegment = Integer.parseInt(String.valueOf(segment));
            if (currentSegment == 0 && lev > 1) {
                lev--;
                continue;
            }
            String numberToString = String.valueOf(currentSegment);
            if (numberToString.length() == 1) {
                numberToString = "00" + numberToString;
            }
            if (numberToString.length() == 2) {
                numberToString = "0" + numberToString;
            }

            int r1 = Integer.parseInt(numberToString.substring(0, 1));
            int r2 = Integer.parseInt(numberToString.substring(1, 2));
            int r3 = Integer.parseInt(numberToString.substring(2, 3));
            int r23 = Integer.parseInt(numberToString.substring(1, 3));

            if (currentSegment > 99) {
                stringBuilder.append(str100[r1]).append(" ");
            }
            if (r23 > 20) {
                stringBuilder.append(str10[r2]).append(" ");
                if (segments.size() > 1 && lev > 0) {
                    stringBuilder.append(sex[Integer.parseInt(forms[lev - 1][3])][r3]).append(" ");
                } else {
                    stringBuilder.append(sex[0][r3]).append(" ");
                }
            } else {
                if (r23 > 9) {
                    stringBuilder.append(str11[r23 - 9]).append(" ");
                } else {
                    if (segments.size() > 1 && lev > 0) {
                        stringBuilder.append(sex[Integer.parseInt(forms[lev - 1][3])][r3]).append(" ");
                    } else {
                        stringBuilder.append(sex[0][r3]).append(" ");
                    }
                }
            }
            if (lev != 0) {
                stringBuilder.append(inclinationToForms(currentSegment, forms[lev - 1][0], forms[lev - 1][1], forms[lev - 1][2])).append(" ");
            }
            lev--;
        }
        return stringBuilder.toString();
    }

    String inclinationToForms(long n, String f1, String f2, String f5) {
        n = Math.abs(n) % 100;
        long n1 = n % 10;
        if (n > 10 && n < 20) return f5;
        if (n1 > 1 && n1 < 5) return f2;
        if (n1 == 1) return f1;
        return f5;
    }

    @Override
    public String declinationOnRubles(long value) {
        return this.inclinationToForms(value, "рубль", "рубля", "рублей");
    }

    @Override
    public String declinationOnUSD(long value) {
        return this.inclinationToForms(value, "доллар", "доллара", "долларов");
    }
}
