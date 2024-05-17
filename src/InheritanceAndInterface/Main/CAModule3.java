package InheritanceAndInterface.Main;

import java.util.Scanner;



public class CAModule3 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        CAModule3 o = new CAModule3();
        System.out.println("Enter 1 for Advanced Library Management System \nEnter 2 for DrawablePerson");
        int choice = sc.nextInt();
        switch (choice){
            case 1: o.CAModule3_a(); //instance of class
                break;
            case 2: o.CAModule3_b(); // instance of other class
        }
    }



    private void CAModule3_a(){
        // Create instances of books
        Fiction fictionBook = new Fiction("The Hobbit", "J.R.R. Tolkien", 1937, "Fantasy");
        NonFiction nonFictionBook = new NonFiction("Sapiens", "Yuval Noah Harari", 2014, "History");

        // Create book copies
        BookCopy fictionCopy1 = new BookCopy(fictionBook);
        BookCopy fictionCopy2 = new BookCopy(fictionBook);
        BookCopy nonFictionCopy1 = new BookCopy(nonFictionBook);

        // Create users
        User user1 = new User("user1", 1);
        User user2 = new User("user2", 2);

        // Create an instance of the library
        Library library = new Library();

        // Add books and copies to the library
        library.addBook(fictionBook);
        library.addBook(nonFictionBook);

        // Add users to the library
        library.addUser(user1);
        library.addUser(user2);

        // Display the library collection and user accounts
        library.displayBooks();
        library.displayUsers();

        // Check out and return book copies
        library.checkOutBookCopy(fictionCopy1.hashCode(), user1.getUserId());
        library.checkOutBookCopy(nonFictionCopy1.hashCode(), user2.getUserId());

        library.displayBooks();
        library.displayUsers();

        library.returnBookCopy(fictionCopy1.hashCode());
        library.displayBooks();
        library.displayUsers();
    }

    private void CAModule3_b() {
        PersonComponent p = new PersonComponent(1);

    }
}



