package InventoryAndEvents.Tests;

import InventoryAndEvents.PersonEvent.Event;
import InventoryAndEvents.PersonEvent.EventType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {

    @Test
    void testGetType() {
        Event event = new Event(EventType.UNLUCKY);
        assertEquals(EventType.UNLUCKY, event.getType());

    }

    @Test
    void testSetX() {
        Event event = new Event(EventType.LUCKY);
        event.setX(10.0);
        assertEquals(10.0, event.getX(), 0.001);
    }

    @Test
    void testSetY() {
        Event event = new Event(EventType.LUCKY);
        event.setY(20.0);
        assertEquals(20.0, event.getY(), 0.001);
    }
}