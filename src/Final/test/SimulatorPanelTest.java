package Final.test;

import Final.main.SimulatorPanel;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimulatorPanelTest {

    @Test
    void testInitialization() {
        SimulatorPanel simulatorPanel = new SimulatorPanel();

        assertNotNull(simulatorPanel.getEventComponent());
        assertNotNull(simulatorPanel.getPersonComponent());
        assertEquals(Color.WHITE, simulatorPanel.getBackground());
        assertEquals(1000, simulatorPanel.getNumberPerson());
        assertEquals(250, simulatorPanel.getNumberLuckyEvents());
        assertEquals(250, simulatorPanel.getNumberUnluckyEvents());
    }

    @Test
    void testPaintComponent() {
        // Create an instance of SimulatorPanel
        SimulatorPanel simulatorPanel = new SimulatorPanel();

        // Set the size of the panel for testing
        int panelWidth = 800;
        int panelHeight = 600;
        simulatorPanel.setSize(panelWidth, panelHeight);

        // Create mock Graphics object
        Graphics graphicsMock = mock(Graphics.class);

        // Mock the create() method to return a non-null Graphics object
        when(graphicsMock.create()).thenReturn(graphicsMock);

        // Call paintComponent() with the mock Graphics object
        simulatorPanel.paintComponent(graphicsMock);

        // For example, if you have specific drawing operations in your components,
        // you might want to verify those interactions as well.
        // Assert that the size of the components is set correctly
        assertEquals(panelWidth, simulatorPanel.getPersonComponent().getWidth());
        assertEquals(panelHeight, simulatorPanel.getPersonComponent().getHeight());

        assertEquals(panelWidth, simulatorPanel.getEventComponent().getWidth());
        assertEquals(panelHeight, simulatorPanel.getEventComponent().getHeight());
    }

}
