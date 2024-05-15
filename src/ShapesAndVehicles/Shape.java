package ShapesAndVehicles;

public abstract class Shape {
    public abstract double calculateArea();
}

class Circle extends Shape{
    private double radius;
    public Circle(double r) throws IllegalArgumentException{
        if (r < 0) {
            throw new IllegalArgumentException("Circle cannot be instantiated with a negative radius.");
        }
        radius = r;
    }
    @Override
    public double calculateArea() {
        return radius*radius*Math.PI;
    }
}

class Rectangle extends Shape implements Resizable {
    private double length;
    private double width;

    public Rectangle(double w, double l) throws IllegalArgumentException{
        if (w < 0) {
            throw new IllegalArgumentException("Rectangle cannot be instantiated with a negative width.");
        }else if (l < 0) {
            throw new IllegalArgumentException("Rectangle cannot be instantiated with a negative length.");
        }
        width = w;
        length = l;
    }

    @Override
    public double calculateArea(){
        return width*length;
    }

    @Override
    public void resize(double scalar) throws IllegalArgumentException {
        if (scalar < 0) {
            throw new IllegalArgumentException("Rectangle cannot be resized with a negative scalar.");
        }
        width *= scalar;
        length *= scalar;
    }
}

class Triangle extends Shape {
    private double height;
    private double base;

    public Triangle(double b, double h) throws IllegalArgumentException{
        if (h < 0) {
            throw new IllegalArgumentException("Triangle cannot be instantiated with a negative height");
        }else if (b < 0) {
            throw new IllegalArgumentException("Triangle cannot be instantiated with a negative base.");
        }
        height= h;
        base = b;
    }

    @Override
    public double calculateArea(){
        return (base*height)/2.0;
    }
}

interface Resizable{
    public void resize(double scalar) throws IllegalArgumentException;
}

