package UserFriendlyGUI.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class EventComponent extends JComponent {
    private ArrayList<Event> events;

    private int numberOfLuckyEvents;
    private int numberOfUnluckyEvents;
    private int panelWidth = 402;  // 1024 x 625
    private int panelHeight = 402;
    private static Random random = new Random();

    public EventComponent() {
        this(250, 250); // by default, 250 lucky events, 250 unlucky events
    }


    public EventComponent(int luckyEvents, int unLuckyEvents) {
        this.events = new ArrayList<>();
        this.numberOfLuckyEvents = luckyEvents;
        this.numberOfUnluckyEvents = unLuckyEvents;
        System.out.println(this.getBounds());

        // TODO: create events with random coordinates

        for (int i = 0; i < this.numberOfLuckyEvents; i++) {
            Event event = new Event(EventType.LUCKY);
            events.add(event);
        }

        for (int i = 0; i < this.numberOfUnluckyEvents; i++) {
            Event event = new Event(EventType.UNLUCKY);
            events.add(event);
        }
    }

    // paint the events the very first time with random coordinates,
    // future repaint() should not randomize coordinates, only to move along certain direction a small step
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (Event e : events) {
            if (e.getType() == EventType.LUCKY) {
                g.setColor(Color.green);
            }
            else if (e.getType() == EventType.UNLUCKY) {
                g.setColor(Color.red);
            }

            if (e.getX() == 0 && e.getY() == 0) {
                e.setX(random.nextDouble(this.panelWidth-1)+1); // ensures that the new coordinate is not 0.
                e.setY(random.nextDouble(this.panelHeight-1)+1); // it is still possible that a coordinate set will reach (0,0) and be randomized
            }
            int x =(int) e.getX();
            int y =(int) e.getX();
            int r = (int) e.CIRCLE_RADIUS;
            g.fillOval(x,y,r,r);
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
