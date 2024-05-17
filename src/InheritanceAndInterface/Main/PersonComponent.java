package InheritanceAndInterface.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class PersonComponent extends JComponent {
    private int numberOfPerson;
    private ArrayList<DrawablePerson> people;
    private double mean = 0.6;
    private double stdDev = 0.1;
    // Create a random number generator
    private Random random;
    private Image image1, image2;
    private int image1Width, image1Height;
    private int image2Width, image2Height;
    private int panelWidth = 402;
    private int panelHeight = 402;

    public PersonComponent()
    {
        this(1000);
    }

    public PersonComponent(int numberOfPerson) {
        random = new Random();
        this.numberOfPerson = numberOfPerson;
        people = new ArrayList<>();

        try {
            // Load the PNG image files
            image1 = ImageIO.read(new File("C:\\Users\\wilke\\Pictures\\Political Memes\\WAITWHAT.jpg"));
            image2 = ImageIO.read(new File("C:\\Users\\wilke\\Pictures\\Random Memes\\cover3.jpg"));

            image1Width = image1.getWidth(null);
            image1Height = image1.getHeight(null);
            image2Width = image2.getWidth(null);
            image2Height = image2.getHeight(null);

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < numberOfPerson; i++) {
            Image img = (random.nextBoolean()) ? image1: image2;
            DrawablePerson p = new DrawablePerson(generateNormalDistributionValue(this.mean,this.stdDev),img);
            p.setX(Math.abs(random.nextInt(400)));
            p.setY(Math.abs(random.nextInt(400)));
            people.add(p);
        }

    }

    // Function to generate a random number from a normal distribution
    private double generateNormalDistributionValue(double mean, double stdDev) {
        return this.mean + this.stdDev * this.random.nextGaussian();
    }

    @Override
    public void paintComponent(Graphics g) {
        for (DrawablePerson p : people){
            p.draw(g);
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

    public ArrayList<DrawablePerson> getPeople() {
        return people;
    }
}

