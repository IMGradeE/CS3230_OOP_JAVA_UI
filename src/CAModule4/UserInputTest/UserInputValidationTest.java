package CAModule4.UserInputTest;

import CAModule4.UserInput.UserInputValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInputValidationTest {

    private UserInputValidation userInputValidation;

    @BeforeEach
    void setUp() {
        userInputValidation = new UserInputValidation();
    }

    @Test
    void testGetIntInputValidInput() {
        String input = "42\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        int result = userInputValidation.getIntInput(scanner);

        assertEquals(42, result);
    }

    @Test
    void testGetIntInputInvalidInputThenValidInput() {
        String input = "invalid\n42\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        int result = userInputValidation.getIntInput(scanner);

        assertEquals(42, result);
    }

    @Test
    void testGetDoubleInputValidInput() {
        String input = "3.14\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        double result = userInputValidation.getDoubleInput(scanner);

        assertEquals(3.14, result, 0.001);
    }

    @Test
    void testGetDoubleInputInvalidInputThenValidInput() {
        String input = "invalid\n3.14\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        double result = userInputValidation.getDoubleInput(scanner);

        assertEquals(3.14, result, 0.001);
    }

    @Test
    void testGetInputWithValidInput() {
        String input = "3\n5\n2.5\n10\n100\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        userInputValidation.getInput(scanner);

        assertEquals(3, userInputValidation.getNumberPeople());
        assertEquals(5, userInputValidation.getNumberEvents());
        assertEquals(2.5, userInputValidation.getDistanceThreshold(), 0.001);
        assertEquals(10, userInputValidation.getSimulationSteps());
        assertEquals(100, userInputValidation.getThreadDelayTime());
    }


}
