package ru.otus.service;

import org.junit.jupiter.api.Test;
import ru.otus.service.impl.ApplicationInputServiceImpl;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.otus.utils.Constants.ENTER_THE_NUMBER_MESSAGE;
import static ru.otus.utils.Constants.MAXIMUM_POSSIBLE_LENGTH_EXCEEDED_MESSAGE;

public class ApplicationInputServiceTest {

    private final ApplicationInputService applicationInputService = new ApplicationInputServiceImpl();

    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalErr = System.err;

    @Test
    void shouldReadNumericFromConsole() throws IOException {
        var number = "526";
        var br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(number.getBytes(StandardCharsets.UTF_8))));

        var numberInLong = applicationInputService.readNumericFromConsoleByBufferedReader(br);

        assertEquals(numberInLong, Long.parseLong(number));
    }

    @Test
    void shouldReadNumericFromConsole_WithNumberFormatException() throws IOException {
        var number = "abc";
        var br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(number.getBytes(StandardCharsets.UTF_8))));
        System.setErr(new PrintStream(errContent));

        var numberInLong = applicationInputService.readNumericFromConsoleByBufferedReader(br);

        System.setErr(new PrintStream(originalErr));

        assertEquals(ENTER_THE_NUMBER_MESSAGE + "\r\n", errContent.toString());
        assertEquals(0, numberInLong);
    }

    @Test
    void shouldReadNumericFromConsole_WithNumberFormatException_MoreThanMaximumLength() throws IOException {
        var number = "11111111111111111111";
        var br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(number.getBytes(StandardCharsets.UTF_8))));
        System.setErr(new PrintStream(errContent));

        var numberInLong = applicationInputService.readNumericFromConsoleByBufferedReader(br);

        System.setErr(new PrintStream(originalErr));

        assertEquals(MAXIMUM_POSSIBLE_LENGTH_EXCEEDED_MESSAGE + "\r\n", errContent.toString());
        assertEquals(0, numberInLong);
    }
}
