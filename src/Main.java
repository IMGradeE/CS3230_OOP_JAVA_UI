import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        String welcome_msg ="Welcome to the Number Guessing Game!\n" +
                "I've selected a random number between 1 and 100.\nTry to guess it!";
        String quit_msg = "You quit the game! The number was ";
        String win_msg = "You Win! The number was ";
        String prompt_msg = "Guess the number (or type '-1' to quit the game): ";
        String hint_msg = "Please enter a number between 1 and 100.";
        String guess_high_msg = "Too High! Try again.";
        String guess_low_msg = "Too Low! Try again.";

        int attempts = 0;
        var scanner = new Scanner(System.in);
        int answer = Math.abs(rand.nextInt()%100) + 1;

        /*Number Guessing game, Computer generates a number, Player guesses it.*/
        int guess;
        String response;
        System.out.println(welcome_msg);
        System.out.println(prompt_msg);
        do {
            /*Exception: parseInt fails or number < 1, number > 100, number != -1*/
            // Compare answer and guess
            try {
                guess = Integer.parseInt(scanner.nextLine());
                ++attempts;
                if (guess == -1 || guess == answer){
                    break;
                } else if (guess < 1 || guess > 100) {
                    throw new Exception();
                } else if (guess < answer) {
                    response = guess_low_msg;
                } else {
                    response = guess_high_msg;
                }
            }
            catch (Exception e){ // prompts the user to enter a number within the range.
                // covers both invalid input and out of range input.
                response = hint_msg;
            }
            System.out.println(response + '\n' + prompt_msg);
        }while(true);

        if(guess == -1){
            response = quit_msg + answer + '.';// could also track the closest guess and display here
        }else{
            response = win_msg + answer + '.';
        }
        String attempts_msg = response + "\nYou made " + attempts +" attempts.";
        System.out.println(attempts_msg);
    }
}