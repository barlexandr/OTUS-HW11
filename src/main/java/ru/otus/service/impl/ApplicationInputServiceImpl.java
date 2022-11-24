package ru.otus.service.impl;

import ru.otus.service.ApplicationInputService;

import java.io.BufferedReader;
import java.io.IOException;

import static ru.otus.utils.Constants.*;

public class ApplicationInputServiceImpl implements ApplicationInputService {
    @Override
    public long readNumericFromConsoleByBufferedReader(BufferedReader br) throws IOException {
        var line = br.readLine();
        var i = -1L;
        try (br) {
            return Long.parseLong(line);
        } catch (NumberFormatException e) {
            if (line.length() > MAX_LENGTH_OF_LONG) {
                System.err.println(MAXIMUM_POSSIBLE_LENGTH_EXCEEDED_MESSAGE);
            } else {
                System.err.println(ENTER_THE_NUMBER_MESSAGE);
            }
        }
        return i;
    }
}
