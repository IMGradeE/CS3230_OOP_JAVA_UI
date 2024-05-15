package ShapesAndVehicles;

public class LAModule3B {
    public static void main(String[] args) throws Exception {
        // Test polymorphism
        Vehicle[] vehicles = {
                new Car("Toyota", "Camry", 2022),
                new Motorcycle("Harley-Davidson", "Sportster", 2021)
        };

        System.out.println("Displaying Vehicle Information:");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
        }

        // Test drive functionality and speed-related methods
        System.out.println("\nTesting Drive Functionality:");
        Car car = new Car("Honda", "Civic", 2023);
        Motorcycle motorcycle = new Motorcycle("Yamaha", "MT-07", 2022);

        System.out.println("Initial Speed:");
        car.displaySpeed();
        motorcycle.displaySpeed();

        System.out.println("\nDriving Actions:");
        car.drive();
        motorcycle.drive();

        System.out.println("\nAccelerating and Displaying Speed:");
        car.accelerate();
        car.displaySpeed();

        System.out.println("\nDecelerating and Displaying Speed:");
        car.decelerate();
        car.displaySpeed();

        System.out.println("\nMotorcycle Doing a Wheelie:");
        motorcycle.wheelie();

        System.out.println("\nFinal Speeds:");
        car.displaySpeed();
        motorcycle.displaySpeed();
    }
}
