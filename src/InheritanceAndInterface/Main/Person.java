package InheritanceAndInterface.Main;

import java.util.ArrayList;

public class Person {
    private int age;
    private double talent;
    private double capital;
    private double x, y;           // coordinate in the simulator
    private int imageLabel;     // which image to visualize this person

    private ArrayList<Event> events;

    public static final double INIT_CAPITAL = 10.0;

    public Person(double talent) {
        this.talent = talent;
        this.age = 0;
        this.capital = INIT_CAPITAL;
        events = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public double getTalent() {
        return talent;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
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
}
