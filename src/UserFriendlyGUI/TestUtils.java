package UserFriendlyGUI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestUtils {
    public static String getConsoleOutput(Runnable codeToRun) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        codeToRun.run(); // Execute the code
        System.setOut(originalOut); // Restore the original output stream
        return outputStream.toString();
    }
}
