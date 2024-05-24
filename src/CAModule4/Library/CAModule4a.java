package CAModule4.Library;
import java.util.Scanner;
public class CAModule4a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        try {
            while (true) {
                try{
                    System.out.println("\nLibrary Book Checkout System");
                    System.out.println("1. Display Available Books");
                    System.out.println("2. Check Out a Book");
                    System.out.println("3. Return a Book");
                    System.out.println("4. Exit");
                    System.out.print("Select an option (1-4): ");

                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            library.displayAvailableBooks();
                            break;
                        case 2:
                            System.out.print("Enter the Book ID to check out: ");
                            int checkOutBookId = InputValidator.validateBookId(scanner.nextLine());
                            library.checkOutBook(checkOutBookId);
                            break;
                        case 3:
                            System.out.print("Enter the Book ID to return: ");
                            int returnBookId = InputValidator.validateBookId(scanner.nextLine());
                            library.returnBook(returnBookId);
                            break;
                        case 4:
                            System.out.println("Exiting the program. Thank you!");
                            return;
                        default:
                            System.out.println("Invalid option. Please select a valid option (1-4).");
                    }
                }
                catch (Library.BookCheckoutException | Library.BookReturnException e){
                    continue;
                }
            }
        }
        catch (Exception e) {
            System.out.println("An unexpected error occurred. Exiting the program.");
            e.printStackTrace();
        }
        finally {
            library.closeLogger();
            scanner.close();
        }
    }
}
