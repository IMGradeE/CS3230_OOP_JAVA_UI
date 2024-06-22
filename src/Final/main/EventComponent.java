package Final.main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class EventComponent extends JComponent {
    private ArrayList<Final.main.Event> events;

    private int numberOfLuckyEvents;
    private int numberOfUnluckyEvents;
    private int panelWidth = 402;  // 1024 x 625
    private int panelHeight = 402;

    public EventComponent() {
        this(250, 250); // by default, 250 lucky events, 250 unlucky events
    }


    public EventComponent(int luckyEvents, int unLuckyEvents) {
        this.events = new ArrayList<>();
        this.numberOfLuckyEvents = luckyEvents;
        this.numberOfUnluckyEvents = unLuckyEvents;
        System.out.println(this.getBounds());

        // create events with random coordinates
        Random random = new Random();
        double x, y;

        for (int i = 0; i < numberOfLuckyEvents; i++) {
            x = random.nextDouble(panelWidth - 2 * Event.CIRCLE_RADIUS) + Event.CIRCLE_RADIUS;
            y = random.nextDouble(panelHeight - 2 * Event.CIRCLE_RADIUS) + Event.CIRCLE_RADIUS;
            Event event = new Event(EventType.LUCKY);
            event.setX(x);
            event.setY(y);
            events.add(event);
        }
        for (int i = 0; i < numberOfUnluckyEvents; i++) {
            x = random.nextDouble(panelWidth - 2 * Event.CIRCLE_RADIUS) + Event.CIRCLE_RADIUS;
            y = random.nextDouble(panelHeight - 2 * Event.CIRCLE_RADIUS) + Event.CIRCLE_RADIUS;
            Event event = new Event(EventType.UNLUCKY);
            event.setX(x);
            event.setY(y);
            events.add(event);
        }

    }

    // paint the events the very first time with random coordinates,
    // future repaint() should not randomize coordinates, only to move along certain direction a small step
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for(Final.main.Event e : events)
        {
            Color color;
            if(e.getType() == EventType.LUCKY)
            {
                color = Color.GREEN;
            }
            else {
                color = Color.RED;
            }
            g.setColor(color);
            g.fillOval((int)(e.getX() - Final.main.Event.CIRCLE_RADIUS), (int)(e.getY() - Final.main.Event.CIRCLE_RADIUS), (int)(2 * Final.main.Event.CIRCLE_RADIUS), (int)(2 * Final.main.Event.CIRCLE_RADIUS));

        }

    }

    public int getPanelWidth() {
        return panelWidth;
    }

    public void setPanelWidth(int panelWidth) {
        this.panelWidth = panelWidth;
    }

    public int getPanelHeight() {
        return panelHeight;
    }

    public void setPanelHeight(int panelHeight) {
        this.panelHeight = panelHeight;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public int getNumberOfLuckyEvents() {
        return numberOfLuckyEvents;
    }

    public int getNumberOfUnluckyEvents() {
        return numberOfUnluckyEvents;
    }
}
