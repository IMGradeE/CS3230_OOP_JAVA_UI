package PersonEvent.TEST;

import static org.junit.jupiter.api.Assertions.*;

import PersonEvent.MAIN.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.geom.Rectangle2D;

public class EventTest {
    private Event event;
    private Rectangle2D bounds;

    @BeforeEach
    void setUp() {
        event = new Event();
        bounds = new Rectangle2D.Double(0, 0, 100, 100);
    }

    @Test
    void testGetX() {
        assertEquals(0.0, event.getX(), 0.001);
    }

    @Test
    void testSetX() {
        event.setX(10.0);
        assertEquals(10.0, event.getX(), 0.001);
    }

    @Test
    void testGetY() {
        assertEquals(0.0, event.getY(), 0.001);
    }

    @Test
    void testSetY() {
        event.setY(5.0);
        assertEquals(5.0, event.getY(), 0.001);
    }

    @Test
    public void testMoveWithinBounds() {
        double initialX = event.getX();
        double initialY = event.getY();

        event.move(bounds);

        assertNotEquals(initialX, event.getX());
        assertNotEquals(initialY, event.getY());
        assertTrue(event.getX() >= bounds.getMinX());
        assertTrue(event.getX() + Event.CIRCLE_RADIUS < bounds.getMaxX());
        assertTrue(event.getY() >= bounds.getMinY());
        assertTrue(event.getY() + Event.CIRCLE_RADIUS < bounds.getMaxY());
    }

    @Test
    public void testMoveBoundaryReflection() {
        event.setX(95);
        event.setY(95);

        event.move(bounds);

        assertEquals(-2, event.getDx(), 0.01);
        assertEquals(-2, event.getDy(), 0.01);
    }

    @Test
    public void testMoveCornerReflection() {
        event.setX(0);
        event.setY(0);

        event.move(bounds);

        assertEquals(2, event.getDx(), 0.01);
        assertEquals(2, event.getDy(), 0.01);
    }

    @Test
    public void testMoveNegativeBoundaryReflection() {
        event.setX(0);
        event.setY(0);

        event.move(bounds);

        assertEquals(2, event.getDx(), 0.01);
        assertEquals(2, event.getDy(), 0.01);
    }
}