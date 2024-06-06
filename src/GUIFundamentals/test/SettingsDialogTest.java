package GUIFundamentals.test;

import GUIFundamentals.main.SettingsDialog;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class SettingsDialogTest {

    private SettingsDialog settingsDialog;

    @Mock
    private JFrame frame;

    @BeforeEach
    void setUp() {
        frame = new JFrame("Settings Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settingsDialog = new SettingsDialog(frame);

    }

    @Test
    void testComponentsInitialization() {
        assertNotNull(settingsDialog.getCancelButton());
        assertNotNull(settingsDialog.getDelayLabel());
        assertNotNull(settingsDialog.getDelayTextField());
        assertNotNull(settingsDialog.getNumberEventLabel());
        assertNotNull(settingsDialog.getNumberEventTextField());
        assertNotNull(settingsDialog.getNumberPeopleLabel());
        assertNotNull(settingsDialog.getNumberPeopleTextField());
        assertNotNull(settingsDialog.getOkButton());
        assertNotNull(settingsDialog.getStepsLabel());
        assertNotNull(settingsDialog.getStepsTextField());
        assertNotNull(settingsDialog.getThresholdComboBox());
        assertNotNull(settingsDialog.getThresholdLabel());
    }

    @Test
    void testSaveSettingsEmptyFields() {
        // Simulate empty fields
        settingsDialog.getNumberPeopleTextField().setText("");
        settingsDialog.getNumberEventTextField().setText("");
        settingsDialog.getStepsTextField().setText("");
        settingsDialog.getDelayTextField().setText("");

        settingsDialog.saveSettings(false); // Trigger validation

        // Ensure warning messages are displayed
        assertTrue(settingsDialog.getWarnings().toString().contains("Number of People field must not be empty."));
        assertTrue(settingsDialog.getWarnings().toString().contains("Number of Event field must not be empty."));
        assertTrue(settingsDialog.getWarnings().toString().contains("Simulation Steps must not be empty."));
        assertTrue(settingsDialog.getWarnings().toString().contains("Thread Delay Time must not be empty."));
    }

    @Test
    void testSaveSettingsNonIntegerFields() {
        // Simulate non-integer input in some fields
        settingsDialog.getNumberPeopleTextField().setText("abc");
        settingsDialog.getNumberEventTextField().setText("123");
        settingsDialog.getStepsTextField().setText("45");
        settingsDialog.getDelayTextField().setText("xyz");

        settingsDialog.saveSettings(false); // Trigger validation

        // Ensure warning messages are displayed
        assertTrue(settingsDialog.getWarnings().toString().contains("Number of People must be an integer number."));
        assertFalse(settingsDialog.getWarnings().toString().contains("Number of Events must be an integer number."));
        assertFalse(settingsDialog.getWarnings().toString().contains("Simulation Steps must be an integer number."));
        assertTrue(settingsDialog.getWarnings().toString().contains("Thread Delay Time must be an integer number."));
    }

    // Add more test cases to cover additional scenarios

    @AfterEach
    void cleanUp()
    {
        settingsDialog.dispose();
        frame.dispose();
    }
}
