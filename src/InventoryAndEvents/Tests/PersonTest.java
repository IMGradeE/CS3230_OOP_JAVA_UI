package InventoryAndEvents.Tests;

import InventoryAndEvents.PersonEvent.EventType;
import InventoryAndEvents.PersonEvent.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
    @Test
    void testGetAge() {
        Person person = new Person(5.0);
        assertEquals(0, person.getAge());
    }

    @Test
    void testGetTalent() {
        Person person = new Person(7.5);
        assertEquals(7.5, person.getTalent(), 0.001); // Using delta for double comparison
    }

    @Test
    void testGetCapital() {
        Person person = new Person(3.0);
        assertEquals(10.0, person.getCapital(), 0.001); // Initial capital value
    }

    @Test
    void testSetCapital() {
        Person person = new Person(3.0);
        person.setCapital(15.0);
        assertEquals(15.0, person.getCapital(), 0.001);
    }

    @Test
    void testGetEvents() {
        Person person = new Person(2.0);
        ArrayList<InventoryAndEvents.PersonEvent.Event> events = new ArrayList<>();
        events.add(new InventoryAndEvents.PersonEvent.Event(EventType.LUCKY));
        events.add(new InventoryAndEvents.PersonEvent.Event(EventType.LUCKY));
        person.setEvents(events);
        assertEquals(events, person.getEvents());
    }

    @Test
    void testGetImageLabel() {
        Person person = new Person(4.0);
        person.setImageLabel(1);
        assertEquals(1, person.getImageLabel());
    }

    @Test
    void testGetX() {
        Person person = new Person(3.0);
        person.setX(4.5);
        assertEquals(4.5, person.getX(), 0.001);
    }

    @Test
    void testGetY() {
        Person person = new Person(2.0);
        person.setY(3.5);
        assertEquals(3.5, person.getY(), 0.001);
    }
}