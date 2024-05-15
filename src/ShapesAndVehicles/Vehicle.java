package ShapesAndVehicles;

import java.security.InvalidParameterException;

// derived classes could check the validity of a vehicle by first
// checking if years is a key to the value of the make + model in an Entry<year,make+model>
// I think this would be inefficient as described but could be optimized well
public abstract class Vehicle implements Driveable {
    public Vehicle(String make, String model, int year) throws InvalidParameterException {
        if (make == null || make.isEmpty() || model == null || model.isEmpty()) {
            throw new InvalidParameterException("Make or Model cannot be empty");
        }else if (year < MIN_YEAR || year > MAX_YEAR) {
            throw new InvalidParameterException("Year must be between 1900 and 2025.");
        }
        this.make = make;
        this.model = model;
        this.year = year;
        this.speed = 0.0;
        this.driving = false;
    }
    protected String make;
    protected String model;
    protected int year;
    protected double speed;
    private static final int MIN_YEAR = 1900;
    private static final int MAX_YEAR = 2025;
    private static final double MAX_SPEED_KM = 280.0;
    private static final double SPEED_INCREMENT_KM = 15.0;
    private static final double SPEED_DECREMENT_KM = 10.0;
    protected boolean driving;
    @Override
    public void drive() {
        if (this.driving) {
            this.speed = 0.00;
            System.out.printf("The %d %s %s has stopped.%n", year, make, model);
        }else{
            this.speed = 15.00;
            System.out.printf("The %d %s %s is driving.%n", year, make, model);
        }
        this.driving = !this.driving;
    }
    protected void displayInfo(){
        System.out.printf("Make: %s\nModel: %s\nYear: %d\n%n",make,model,year);
    }
    protected void displaySpeed(){
        System.out.printf("Current Speed: %d km/h%n",(int) speed);
    }
    protected void accelerate(){
        if (!this.driving){
            System.out.println("The " + make+ " " + model + " is not driving and cannot decelerate.");
        }else{
            if (this.speed <= MAX_SPEED_KM - SPEED_INCREMENT_KM){
                this.speed += SPEED_INCREMENT_KM;
                System.out.printf("The %d %s %s is accelerating.%n", year, make, model);
            }else {
                this.speed = MAX_SPEED_KM;
                System.out.printf("The %d %s %s has reached its top speed!%n", year, make, model);
            }
        }
    }
    protected void decelerate(){
        if (!this.driving){
            System.out.println("The " + make+ " " + model + " is not driving and cannot decelerate.");
        }else{
            if(this.speed >= SPEED_DECREMENT_KM){
                this.speed -= 10.0;
                System.out.printf("The %d %s %s is decelerating.%n", year, make, model);
            }else {
                drive();
            }
        }
    }

    // Could implement overrides for accel/decel that account for average values based on vehicle
    // class, and year, with a sleep() call for the dynamically calculated time needed to change
    // the speed by the amount in the argument. Coefficients, maximums, and non-linear changes in coefficients
    // could also be included from real world sources with as much granularity as one desires.
}

class Car extends Vehicle{
    public Car(String make, String model, int year) {
        super(make, model, year);
        // subclass specific checks for make/model could be made here if desired.
        // Any other initialization actions specific to this subtype can also be made here.
    }
    protected void displaySpeed(){
        super.displaySpeed();
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model, int year) {
        super(make, model, year);
    }
    // methods
    public void wheelie(){
        if(this.driving){
            System.out.printf("The %d %s %s is doing a wheelie!%n", year, make, model); //
        }
    }
    public void rollStoppie(){
        if(this.driving && this.speed >= 30){
            System.out.printf("The %d %s %s is rolling a stoppie!%n", year, make, model); //
            this.speed = this.speed/2;
        }else {
            System.out.printf("The %d %s %s is going too slow to roll a stoppie.%n", year, make, model);
        }
    }
    public void stoppie(){
        if(this.driving && this.speed >= 30){
            System.out.printf("The %d %s %s is doing a stoppie!%n", year, make, model); //
            this.speed = 0;
        }else {
            System.out.printf("The %d %s %s is going too slow to do a stoppie.%n", year, make, model);
        }
    }
    protected void displaySpeed(){
        super.displaySpeed();
    }
}

interface Driveable{
    void drive();
}

