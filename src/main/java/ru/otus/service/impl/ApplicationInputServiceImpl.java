package ru.otus.service.impl;

import ru.otus.service.ApplicationInputService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ru.otus.utils.Constants.MAX_LENGTH_OF_LONG;

public class ApplicationInputServiceImpl implements ApplicationInputService {
    @Override
    public long readNumericFromConsole() throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var line = br.readLine();
        var i = 0L;
        try {
            return Long.parseLong(line);
        } catch (NumberFormatException e) {
            if (line.length() > MAX_LENGTH_OF_LONG) {
                System.err.println("Maximum possible string length exceeded");
            } else {
                System.err.println("Enter the number, please.");
            }
        }
        return i;
    }
}
