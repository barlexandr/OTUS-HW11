package ru.otus.service;

import java.io.BufferedReader;
import java.io.IOException;

public interface ApplicationInputService {
    long readNumericFromConsoleByBufferedReader(BufferedReader bf) throws IOException;
}