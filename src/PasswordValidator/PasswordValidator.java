package PasswordValidator;

import java.util.Scanner;
import java.util.logging.*;
import java.util.regex.Pattern;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordValidatorLogic passwordValidatorLogic = new PasswordValidatorLogic();
        InputValidator inputValidator = new InputValidator();
        LoggerManager loggerManager = new LoggerManager();
        AttemptCounter attemptCounter = new AttemptCounter();

        for (int attempt = 1; attempt <= AttemptCounter.MAX_ATTEMPTS; attempt++) {
            System.out.print("Enter a password: ");
            String password = scanner.nextLine();
            try {
                inputValidator.validateInput(password);
                passwordValidatorLogic.validatePassword(password);
                loggerManager.logInfo("Password validation successful for attempt " + attempt);
                System.out.println("Password is valid. Access granted!");
                break; // Exit the loop on successful validation
            } catch (InvalidInputException | InvalidPasswordException e) {
                loggerManager.logWarning("Password validation failed for attempt " + attempt + ": " + e.getMessage());
                System.out.println("Invalid password: " + e.getMessage());
                if (attempt < AttemptCounter.MAX_ATTEMPTS) {
                    System.out.println("You have " + (AttemptCounter.MAX_ATTEMPTS - attempt) + " attempts remaining.\n");
                } else {
                    System.out.println("Maximum attempts reached. Access denied.");
                }
            }
        }

        scanner.close();
        loggerManager.closeLogger();
    }
}
// use of regular expressions in this fashion is completely unnecessary but I wanted to play around with them.
class PasswordValidatorLogic {
    private static final Pattern patternA = Pattern.compile("^.*[A-Z]++.*$");
    private static final Pattern patternB = Pattern.compile("^.*[a-z]++.*$");
    private static final Pattern patternC = Pattern.compile("^.*[0-9]++.*$");
    private static final Pattern patternD = Pattern.compile("^.*\\p{Punct}++.*$");

    public void validatePassword(String password) throws InvalidPasswordException {
        
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password must be at least 8 characters");
        } else if (!patternA.matcher(password).matches()){
            throw new InvalidPasswordException("Password must contain at least one UpperCase letter");
        } else if (!patternB.matcher(password).matches()){
            throw new InvalidPasswordException("Password must contain at least one LowerCase letter");
        }else if (!patternC.matcher(password).matches()){
            throw new InvalidPasswordException("Password must contain at least one Digit");
        } else if (!patternD.matcher(password).matches()){
            throw new InvalidPasswordException("Password must contain at least one Special Character (e.g., @, #, $, %)");
        }
    }
}

class InputValidator {
    public void validateInput(String input) throws InvalidInputException {
        //input cannot contain spaces or be an empty string.
        if (input.isBlank()){
            throw new InvalidInputException("Password cannot be blank.");
        }else if (input.indexOf(' ') != - 1){
            throw new InvalidInputException("Password cannot contain spaces.");
        }
    }
}

class LoggerManager {
    private Logger localLogger = Logger.getLogger(PasswordValidator.class.getName());

    private FileHandler fileHandler;
    public LoggerManager() {
        try{
            fileHandler = new FileHandler("Info_Warning_Logs");
            fileHandler.setFormatter(new XMLFormatter());
            fileHandler.setLevel(Level.WARNING);
            localLogger.addHandler(fileHandler);
        }catch (Exception e){System.out.println("Could not initialize Filehandler, no logs are being written to file.");}
    }
    public void logInfo(String message) {
        localLogger.setLevel(Level.INFO);
        localLogger.log(Level.INFO, message);
    }

    public void logWarning(String message) {
        localLogger.setLevel(Level.WARNING);
        localLogger.log(Level.WARNING, message);
    }

    public void closeLogger() {
        localLogger.removeHandler(fileHandler);
    }
}

class AttemptCounter {
    public static final int MAX_ATTEMPTS = 3;
    private int currentAttempt;

    AttemptCounter() {
        this.currentAttempt = 1;
    }

    public int getCurrentAttempt() {
        return currentAttempt;
    }

    public void incrementAttempt() {
        currentAttempt++;
    }
}

class InvalidPasswordException extends Exception {
    InvalidPasswordException(String message) {
        super(message);
    }
}

class InvalidInputException extends Exception {
    InvalidInputException(String message) {
        super(message);
    }
}
