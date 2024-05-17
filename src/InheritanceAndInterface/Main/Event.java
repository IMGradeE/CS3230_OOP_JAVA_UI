package InheritanceAndInterface.Main;

import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Event {
    private EventType type;
    public static final double CIRCLE_RADIUS = 3;
    private double x = 0;
    private double y = 0;
    private double dx = 2;
    private double dy = 2;
    public Event(EventType type) {
        this.type = type;
    }

    public void move(Rectangle2D bounds)
    {
        Random random = new Random();
        // Generate a random number that is either -1 or 1
        int randomNumber = random.nextBoolean() ? 1 : -1;
        x += dx * randomNumber;

        randomNumber = random.nextBoolean() ? 1 : -1;
        y += dy * randomNumber;

        if (x < bounds.getMinX())
        {
            x = bounds.getMinX();
            dx = -dx;
        }
        if (x + CIRCLE_RADIUS >= bounds.getMaxX())
        {
            x = bounds.getMaxX() - CIRCLE_RADIUS;
            dx = -dx;
        }
        if (y < bounds.getMinY())
        {
            y = bounds.getMinY();
            dy = -dy;
        }
        if (y + CIRCLE_RADIUS >= bounds.getMaxY())
        {
            y = bounds.getMaxY() - CIRCLE_RADIUS;
            dy = -dy;
        }
    }

    public EventType getType() {
        return type;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
