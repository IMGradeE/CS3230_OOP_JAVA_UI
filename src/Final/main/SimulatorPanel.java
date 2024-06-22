package Final.main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SimulatorPanel extends JPanel {
    private Image image1;
    private Image image2;
    private Random random;
    private int image1Width, image1Height;
    private int image2Width, image2Height;
    private int numberPerson = 1000;
    private int numberLuckyEvents = 250;
    private int numberUnluckyEvents = 250;


    private EventComponent eventComponent;
    private PersonComponent personComponent;

    public SimulatorPanel() {
        /* TODO: instantiate EventComponent with the given parameters;
            Add the EventComponent to the panel using the add method;
            Instantiate PersonComponent with the given parameter;
            Add the PersonComponent to the panel using the add method.
            Set the background color of the panel to white.
         */
        eventComponent = new EventComponent(numberLuckyEvents,numberUnluckyEvents);
        personComponent = new PersonComponent(numberPerson);
        this.add(eventComponent);
        this.add(personComponent);

        this.setBackground(Color.WHITE);

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* TODO: Set Bounds for personComponent and eventComponent Bounds using the SimulatorPanel width and height
            such that each component covers the entire CustomPanel using the setBounds method.
            Ensure that the width and height of each component are updated using the setPanelWidth and setPanelHeight methods;
            then display each component using their paintComponent method to ensure they are displayed within the CustomPanel.
         */
        eventComponent.setBounds(0,0, this.getWidth(), this.getHeight());
        personComponent.setBounds(0,0, this.getWidth(), this.getHeight());
        personComponent.paintComponent(g);
        eventComponent.paintComponent(g);
    }

    public EventComponent getEventComponent() {
        return eventComponent;
    }

    public PersonComponent getPersonComponent() {
        return personComponent;
    }

    public int getNumberPerson() {
        return numberPerson;
    }

    public void setNumberPerson(int numberPerson) {
        this.numberPerson = numberPerson;
    }

    public int getNumberLuckyEvents() {
        return numberLuckyEvents;
    }

    public void setNumberLuckyEvents(int numberLuckyEvents) {
        this.numberLuckyEvents = numberLuckyEvents;
    }

    public int getNumberUnluckyEvents() {
        return numberUnluckyEvents;
    }

    public void setNumberUnluckyEvents(int numberUnluckyEvents) {
        this.numberUnluckyEvents = numberUnluckyEvents;
    }

    public void setEventComponent(EventComponent eventComponent) {
        this.eventComponent = eventComponent;
    }

    public void setPersonComponent(PersonComponent personComponent) {
        this.personComponent = personComponent;
    }
}

