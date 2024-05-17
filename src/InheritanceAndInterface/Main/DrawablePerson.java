package InheritanceAndInterface.Main;

import java.awt.*;

public class DrawablePerson extends Person implements Drawable, Comparable<Person> {
    private int imageHeight;
    private int imageWidth;
    private Image personImage;
    public DrawablePerson(double talent, Image personImage){
        super(talent);
        this.personImage = personImage;
        this.imageHeight = personImage.getHeight(null);
        this.imageWidth = personImage.getWidth(null);
    }

    @Override
    public void draw(Graphics g) {
        //g.drawImage(personImage,0,0, imageWidth, imageHeight,null); Does not pass test cases
        g.drawImage(personImage,imageWidth, imageHeight,null);
    }

    @Override
    public int compareTo(Person o) {
        int returnVal;
        if(this.getCapital() < o.getCapital()){
            returnVal = -1;
        } else if (this.getCapital() == o.getCapital()) {
            returnVal = 0;
        }else{
            returnVal = 1;
        }
        return returnVal;
    }


}