package InventoryAndEvents.PersonEvent;

import java.util.ArrayList;

public class Person {
    private int age;
    private double talent;
    private double capital;
    private double x, y;           // coordinate in the simulator
    private int imageLabel;     // which image to visualize this person
    public static final double INIT_CAPITAL = 10.0;
    private ArrayList<InventoryAndEvents.PersonEvent.Event> events;

    public Person(double talent) {
        this.talent = talent;
        this.age = 0;
        this.capital = INIT_CAPITAL;
        events = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int a){
        age = a;
    }

    public double getTalent() {
        return talent;
    }

    public void setTalent(double talent) {
        this.talent = talent;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public int getImageLabel() {
        return imageLabel;
    }

    public void setImageLabel(int imageLabel) {
        this.imageLabel = imageLabel;
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

    public ArrayList<InventoryAndEvents.PersonEvent.Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<InventoryAndEvents.PersonEvent.Event> events) {
        this.events = events;
    }
}
