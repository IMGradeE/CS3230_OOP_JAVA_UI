package UserFriendlyGUI.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.Event;
import java.util.ArrayList;

public class EventComponent extends JComponent {
    private ArrayList<java.awt.Event> events;

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

        // TODO: create events with random coordinates



    }

    // paint the events the very first time with random coordinates,
    // future repaint() should not randomize coordinates, only to move along certain direction a small step
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // TODO: paint all events



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
