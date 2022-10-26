package ru.otus.service.impl;

import ru.otus.enums.CurrencyEnum;
import ru.otus.service.ActionService;
import ru.otus.service.ApplicationInputService;
import ru.otus.service.ApplicationOutputService;
import ru.otus.service.ParseService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActionServiceImpl implements ActionService {

    private final ApplicationInputService inputService = new ApplicationInputServiceImpl();
    private final ApplicationOutputService outputService = new ApplicationOutputServiceImpl();
    private final ParseService parseService = new ParseServiceImpl();

    @Override
    public void actionWithNumeric() throws IOException {
        while (true) {
            var br = new BufferedReader(new InputStreamReader(System.in));
            var input = inputService.readNumericFromConsoleByBufferedReader(br);
            var result = parseService.currencyNameDeclination(CurrencyEnum.RUB, input);
            outputService.printWords(result);
        }
    }
}
