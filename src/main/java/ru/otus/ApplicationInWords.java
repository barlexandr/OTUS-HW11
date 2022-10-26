package ru.otus;

import ru.otus.service.ActionService;
import ru.otus.service.impl.ActionServiceImpl;

import java.io.IOException;

public class ApplicationInWords {
    private static final ActionService actionService = new ActionServiceImpl();

    public static void main(String[] args) throws IOException {
        actionService.actionWithNumeric();
    }
}
