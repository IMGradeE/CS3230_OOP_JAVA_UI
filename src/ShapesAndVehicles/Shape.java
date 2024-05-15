package ShapesAndVehicles;

public abstract class Shape {
    public abstract double calculateArea();
    protected double radius;
    protected double height;
    protected double width;
}

class Circle extends Shape{
    public Circle(double r) throws IllegalArgumentException{
        if (radius < 0) {
            throw new IllegalArgumentException("Circle cannot be instantiated with a negative radius.");
        }
        this.radius = r;
    }
    @Override
    public double calculateArea() {
        return radius*radius*Math.PI;
    }
}

class Rectangle extends Shape implements Resizable {
    public Rectangle(double w, double h) throws IllegalArgumentException{
        if (w < 0) {
            throw new IllegalArgumentException("Rectangle cannot be instantiated with a negative width.");
        }else if (h < 0) {
            throw new IllegalArgumentException("Rectangle cannot be instantiated with a negative length.");
        }
        this.width = w;
        this.height = h;
    }

    @Override
    public double calculateArea(){
        return width*height;
    }

    @Override
    public void resize(double scalar) throws IllegalArgumentException {
        if (scalar < 0) {
            throw new IllegalArgumentException("Rectangle cannot be resized with a negative scalar.");
        }
        width *= scalar;
        height *= scalar;
    }
}

class Triangle extends Shape {
        public Triangle(double b, double h) throws IllegalArgumentException{
            if (h < 0) {
                throw new IllegalArgumentException("Triangle cannot be instantiated with a negative height");
            }else if (b < 0) {
                throw new IllegalArgumentException("Triangle cannot be instantiated with a negative base.");
            }
            this.width = b;
            this.height = h;
    }

    @Override
    public double calculateArea(){
        return (width*height)/2.0;
    }
}

interface Resizable{
    void resize(double scalar) throws IllegalArgumentException;
}

