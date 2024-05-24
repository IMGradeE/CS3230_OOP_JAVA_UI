package CAModule4.UserInput;

import java.util.Scanner;

public class UserInputValidation {
    private int numberPeople;
    private int numberEvents;
    private double distanceThreshold;
    private int simulationSteps;
    private int threadDelayTime;

    public static void main(String[] args) {
        UserInputValidation userInputValidation = new UserInputValidation();
        userInputValidation.getInput(new Scanner(System.in));
        userInputValidation.displayInputValues();
    }

    // Method for getting integer input with validation
    public int getIntInput(Scanner scanner) {
        String prompt = "Please enter an integer: ";
        while(true){
            System.out.println(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().strip());
            }catch (NumberFormatException e){
                prompt = "Invalid input! Please enter a valid integer: ";
            }
        }

    }

    // Method for getting double input with validation
    public double getDoubleInput(Scanner scanner) {
        String prompt = "Please enter a whole or fractional number: ";
        while(true){
            System.out.println(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().strip());
            }catch (NumberFormatException | NullPointerException e){
                prompt = "Invalid input! Please enter a valid whole or fractional number: ";
            }
        }

    }

    // Method to get input values from the user
    // Updated getInput method that accepts a Scanner as a parameter
    public void getInput(Scanner scanner) {
        System.out.println("Please specify a number for People");
        numberPeople = getIntInput(scanner);
        System.out.println("Please specify a number for Events");
        numberEvents = getIntInput(scanner);
        System.out.println("Please specify a number for the Distance Threshold");
        distanceThreshold = getDoubleInput(scanner);
        System.out.println("Please specify a number for Simulation Steps");
        simulationSteps = getIntInput(scanner);
        System.out.println("Please specify a number for the Thread Delay Time");
        threadDelayTime = getIntInput(scanner);

    }

    // Method to display input values
    private void displayInputValues() {
        System.out.println("\nInput values:");
        System.out.println("Number of People: " + numberPeople);
        System.out.println("Number of Events: " + numberEvents);
        System.out.println("Distance Threshold: " + distanceThreshold);
        System.out.println("Simulation Steps: " + simulationSteps);
        System.out.println("Thread Delay Time: " + threadDelayTime + " milliseconds");
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    public int getNumberEvents() {
        return numberEvents;
    }

    public double getDistanceThreshold() {
        return distanceThreshold;
    }

    public int getSimulationSteps() {
        return simulationSteps;
    }

    public int getThreadDelayTime() {
        return threadDelayTime;
    }
}


