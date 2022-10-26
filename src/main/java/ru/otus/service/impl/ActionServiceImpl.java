package ru.otus.service.impl;

import ru.otus.enums.CurrencyEnum;
import ru.otus.service.ActionService;
import ru.otus.service.ApplicationInputService;
import ru.otus.service.ApplicationOutputService;
import ru.otus.service.ParseService;

import java.io.IOException;

public class ActionServiceImpl implements ActionService {

    private final ApplicationInputService inputService = new ApplicationInputServiceImpl();
    private final ApplicationOutputService outputService = new ApplicationOutputServiceImpl();
    private final ParseService parseService = new ParseServiceImpl();

    @Override
    public void actionWithNumeric() throws IOException {
        while (true) {
            var input = inputService.readNumericFromConsole();
            var result = parseService.currencyNameDeclination(CurrencyEnum.RUB, input);
            outputService.printWords(result);
        }
    }
}
