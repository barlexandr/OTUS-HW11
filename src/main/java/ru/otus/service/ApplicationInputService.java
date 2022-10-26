package ru.otus.service;

import java.io.IOException;

public interface ApplicationInputService {
    long readNumericFromConsole() throws IOException;
}