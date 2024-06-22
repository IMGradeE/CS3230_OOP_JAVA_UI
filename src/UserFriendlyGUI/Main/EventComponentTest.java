package UserFriendlyGUI.Main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventComponentTest {

    private EventComponent eventComponent;

    @BeforeEach
    public void setUp() {
        eventComponent = new EventComponent(3, 2); // Initialize with specific numbers of lucky and unlucky events
    }

    @Test
    public void testConstructorWithDefaultValues() {
        EventComponent defaultComponent = new EventComponent();
        ArrayList<Event> events = defaultComponent.getEvents();

        // Ensure that the default constructor initializes with 250 lucky and 250 unlucky events
        assertEquals(250, defaultComponent.getNumberOfLuckyEvents());
        assertEquals(250, defaultComponent.getNumberOfUnluckyEvents());
        // Ensure that the number of events created matches the sum of lucky and unlucky events
        assertEquals(500, events.size());
    }

    @Test
    public void testConstructorWithSpecifiedValues() {
        ArrayList<Event> events = eventComponent.getEvents();

        // Ensure that the constructor initializes with the specified number of lucky and unlucky events
        assertEquals(3, eventComponent.getNumberOfLuckyEvents());
        assertEquals(2, eventComponent.getNumberOfUnluckyEvents());
        // Ensure that the number of events created matches the sum of specified lucky and unlucky events
        assertEquals(5, events.size());
    }

    @Test
    public void testPaintComponent() {
        EventComponent component = new EventComponent(250, 250);
        Graphics mockGraphics = Mockito.mock(Graphics.class);
        component.paintComponent(mockGraphics);

        // Verify that the paint method was called for each event
        Mockito.verify(mockGraphics, Mockito.times(500)).fillOval(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    public void testGetEvents() {
        ArrayList<Event> events = eventComponent.getEvents();

        // Ensure that the number of events matches the sum of lucky and unlucky events
        assertEquals(eventComponent.getNumberOfLuckyEvents() + eventComponent.getNumberOfUnluckyEvents(), events.size());
    }

    @Test
    public void testSetPanelWidth() {
        eventComponent.setPanelWidth(500);
        assertEquals(500, eventComponent.getPanelWidth());
    }

    @Test
    public void testSetPanelHeight() {
        eventComponent.setPanelHeight(600);
        assertEquals(600, eventComponent.getPanelHeight());
    }

    @Test
    public void testGetNumberOfLuckyEvents() {
        EventComponent component = new EventComponent(250, 250);
        Assertions.assertEquals(250, component.getNumberOfLuckyEvents());
    }

    @Test
    public void testGetNumberOfUnluckyEvents() {
        EventComponent component = new EventComponent(250, 250);
        Assertions.assertEquals(250, component.getNumberOfUnluckyEvents());
    }

}
