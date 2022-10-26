package ru.otus.service;

import org.junit.jupiter.api.Test;
import ru.otus.service.impl.ApplicationOutputServiceImpl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationOutputServiceTest {

    private final ApplicationOutputService applicationOutputService = new ApplicationOutputServiceImpl();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    void shouldPrintWords() {
        var textToOutput = "text to output";
        System.setOut(new PrintStream(outContent));

        applicationOutputService.printWords(textToOutput);

        System.setOut(new PrintStream(originalOut));

        assertEquals(textToOutput + "\r\n", outContent.toString());
    }
}
