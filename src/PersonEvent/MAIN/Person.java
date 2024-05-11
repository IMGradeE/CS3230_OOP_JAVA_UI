package PersonEvent.MAIN;

public class Person {
    public Person(double talent){
        this.talent= talent;
        age = 0;
        capital = INIT_CAPITAL;
    }
    private int age;
    private double talent;
    private double capital;
    private double x, y;
    private int imageLabel;
    private final double INIT_CAPITAL = 10.0;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
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

    public int getImageLabel() {
        return imageLabel;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public void setImageLabel(int imageLabel) {
        this.imageLabel = imageLabel;
    }
}
