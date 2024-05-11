package PersonEvent.TEST;

import static org.junit.jupiter.api.Assertions.*;
import PersonEvent.MAIN.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {
    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person(5.0);
    }

    @Test
    void testGetAge() {
        assertEquals(0, person.getAge());
    }

    @Test
    void testGetTalent() {
        assertEquals(5.0, person.getTalent(), 0.001);
    }

    @Test
    void testGetCapital() {
        assertEquals(10.0, person.getCapital(), 0.001);
    }

    @Test
    void testSetCapital() {
        person.setCapital(15.0);
        assertEquals(15.0, person.getCapital(), 0.001);
    }

    @Test
    void testGetImageLabel() {
        assertEquals(0, person.getImageLabel());
    }

    @Test
    void testSetImageLabel() {
        person.setImageLabel(1);
        assertEquals(1, person.getImageLabel());
    }

    @Test
    void testGetX() {
        assertEquals(0.0, person.getX(), 0.001);
    }

    @Test
    void testSetX() {
        person.setX(10.0);
        assertEquals(10.0, person.getX(), 0.001);
    }

    @Test
    void testGetY() {
        assertEquals(0.0, person.getY(), 0.001);
    }

    @Test
    void testSetY() {
        person.setY(5.0);
        assertEquals(5.0, person.getY(), 0.001);
    }
}
