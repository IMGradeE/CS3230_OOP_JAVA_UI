package ShapesAndVehicles;

public class LAModule3A {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5.0),
                new Rectangle(4.0, 6.0),
                new Triangle(3.0, 8.0)
        };

        // test polymorphism
        System.out.println("Area of Shapes:");
        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() + ": " + String.format("%.2f",shape.calculateArea()));
        }

        // test resizing for a Rectangle object
        System.out.println("\nResizing a Rectangle:");
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        System.out.println("Original Area: " + String.format("%.2f",rectangle.calculateArea()));

        rectangle.resize(2.0);
        System.out.println("Resized Area: " + String.format("%.2f",rectangle.calculateArea()));

        // additional test cases
        System.out.println("\nAdditional Test Cases:");
        Shape[] additionalShapes = {
                new Circle(3.5),
                new Rectangle(5.0, 5.0),
                new Triangle(6.0, 10.0)
        };

        for (Shape shape : additionalShapes) {
            System.out.println(shape.getClass().getSimpleName() + ": " + String.format("%.2f", shape.calculateArea()));
        }
    }
}
