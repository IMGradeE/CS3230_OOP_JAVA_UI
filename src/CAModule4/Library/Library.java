package CAModule4.Library;

import java.util.HashMap;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Library{
    private static HashMap<Integer,Book> books = new HashMap<>();
    private Logger logger;

    // lol
    public Library(){
        logger = Logger.getLogger(this.getClass().getName());
        books.put(1,new Book(1, "Introduction to Java", "John Doe",  5));
        books.put(2,new Book(2, "Data Structures and Algorithms", "Jane Smith",  3));
        books.put(3,new Book(3, "Object-Oriented Design", "Bob Johnson",  7));
    }

    class BookCheckoutException extends Exception{
        public BookCheckoutException(String msg){
            super(msg);
            logWarn(msg);
        }
    }

    class BookReturnException extends Exception{
        public BookReturnException(String msg){
            super(msg);
            logWarn(msg);
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (int i : books.keySet()){
            Book b = books.get(i);
            System.out.printf("\tBook ID: %s, Title: %s, Author: %s, Available Copies: %d\n",b.getID(),b.getTitle(),b.getAuthor(),b.getAvailable());
        }
    }

    public void checkOutBook(int Id) throws BookCheckoutException {
        Book b = books.get(Id);
        if(b == null){
            throw new BookCheckoutException("\nThe requested Book does not exist. Double check the ID you provided.");
        }else if (b.getAvailable() > 0){
            b.checkOutBook();
            logInf(String.format("\na copy of %s was successfully checked out. (ID:%d)", b.getTitle(),b.getID()));
        }else {
            throw new BookCheckoutException("\nThere are not any copies of the selected book available for checkout. Check back later.");
        }
    }

    public void returnBook(int Id) throws BookReturnException {
        Book b = books.get(Id);
        if(b == null){
            throw new BookReturnException("\nThe book ID you entered does not exist, double check the id you provided matches with the book and try again.");
        }else if (b.allAvailable()){
            throw new BookReturnException("\nAll copies of the book associated with this ID are checked in. Please double check the id you provided matches with the book you are returning and try again.");
        }else {
            b.returnBook();
            logInf(String.format("\nA copy of %s was successfully returned. (ID:%d)", b.getTitle(),b.getID()));
        }

    }

    public void logInf(String msg){
        logger.log(Level.INFO,msg);
    }

    public void logWarn(String msg){
        logger.log(Level.WARNING,msg);
    }

    public void closeLogger() {
        Handler[] handlers = logger.getHandlers();
        for (int i = 0; i < handlers.length; i++) {
            logger.removeHandler(handlers[i]);
        }
    }
}

class Book{
    private int ID;
    private String title;
    private String author;
    private int available;
    private int total;

    public Book(int Id, String Title, String Author){
        ID = Id;
        title = Title;
        author = Author;
        available = 1;
        total = 1;
    }

    public Book(int Id, String Title, String Author, int Total){
        ID = Id;
        title = Title;
        author = Author;
        available = Total;
        total = Total;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getAvailable() {
        return available;
    }

    public int getTotal() {
        return total;
    }

    public void returnBook(){
        ++available;
        System.out.printf("Book returned successfully: %s\n", title);
    }

    public void checkOutBook() {
        --available;
        System.out.printf("Book checked out successfully: %s\n", title);
    }

    public boolean allAvailable() {
        if (available == total){
            return true;
        }else {
            return false;
        }
    }
}

abstract class InputValidator{
    public static int validateBookId(String s) {
        try {
             return Integer.parseInt(s.strip());
        }catch (NumberFormatException e){
            return -1;
        }
    }
}

