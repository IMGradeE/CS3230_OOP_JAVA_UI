import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Rectangle2D;

public class BouncingObjectSimulatorTest {

    @Test
    public void testMoveWithinBounds(){
        BouncingObjectSimulator simulator = new BouncingObjectSimulator();
        Rectangle2D bounds = new Rectangle2D.Double(0, 0, 100, 100);

        double initialX = simulator.getX();
        double initialY = simulator.getY();

        simulator.move(bounds);

        assertNotEquals(initialX, simulator.getX());
        assertNotEquals(initialY, simulator.getY());
        assertTrue(simulator.getX() >= bounds.getMinX());
        assertTrue(simulator.getX() + BouncingObjectSimulator.CIRCLE_RADIUS < bounds.getMaxX());
        assertTrue(simulator.getY() >= bounds.getMinY());
        assertTrue(simulator.getY() + BouncingObjectSimulator.CIRCLE_RADIUS < bounds.getMaxY());
    }

    @Test
    public void testMoveBoundaryReflection() { // changed starting coords to 98,98 to eliminate the contradiction.
        BouncingObjectSimulator simulator = new BouncingObjectSimulator();
        Rectangle2D bounds = new Rectangle2D.Double(0, 0, 100, 100);

        simulator.setX(95);
        simulator.setY(95);

        simulator.move(bounds);

        assertEquals(-2, simulator.getDx(), 0.01);
        assertEquals(-2, simulator.getDy(), 0.01);
    }

    @Test
    public void testMoveCornerReflection() {
        BouncingObjectSimulator simulator = new BouncingObjectSimulator();
        Rectangle2D bounds = new Rectangle2D.Double(0, 0, 100, 100);

        simulator.setX(0);
        simulator.setY(0);

        simulator.move(bounds);

        assertEquals(2, simulator.getDx(), 0.01);
        assertEquals(2, simulator.getDy(), 0.01);
    }

    @Test
    public void testMoveNegativeBoundaryReflection() {
        BouncingObjectSimulator simulator = new BouncingObjectSimulator();
        Rectangle2D bounds = new Rectangle2D.Double(0, 0, 100, 100);

        simulator.setX(0);
        simulator.setY(0);

        simulator.move(bounds);

        assertEquals(2, simulator.getDx(), 0.01);
        assertEquals(2, simulator.getDy(), 0.01);
    }
}
