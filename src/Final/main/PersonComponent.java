package Final.main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class PersonComponent extends JComponent {
    private int numberOfPerson;
    private ArrayList<Person> people;
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
            image1 = ImageIO.read(new File("src/Final/main/illust57-woman-small.png"));
            image2 = ImageIO.read(new File("src/Final/main/illust57-man-small.png"));

            image1Width = image1.getWidth(null);
            image1Height = image1.getHeight(null);
            image2Width = image2.getWidth(null);
            image2Height = image2.getHeight(null);

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < numberOfPerson; i++) {
            double randomTalent = generateNormalDistributionValue(mean, stdDev);
            Person person = new Person(randomTalent);

            // Generate random coordinates for the image's position
            double x = random.nextDouble(panelWidth - image1Width);
            double y = random.nextDouble(panelHeight - image1Height);
            person.setX(x);
            person.setY(y);

            // Randomly select one of the two images and coordinates of the agent
            if(random.nextBoolean())
            {
                person.setImageLabel(1);
            }
            else
            {
                person.setImageLabel(2);
            }
            people.add(person);

        }

    }

    // Function to generate a random number from a normal distribution
    private double generateNormalDistributionValue(double mean, double stdDev) {
        return this.mean + this.stdDev * this.random.nextGaussian();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Person person : people)
        {
            if(person.getImageLabel() == 1)
            {
                g.drawImage(image1, (int)person.getX(), (int)person.getY(), null);
            }
            else
            {
                g.drawImage(image2, (int)person.getX(), (int)person.getY(), null);
            }
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

    public ArrayList<Person> getPeople() {
        return people;
    }
}
