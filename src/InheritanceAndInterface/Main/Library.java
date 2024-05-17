package InheritanceAndInterface.Main;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private static final String LIB_COLLECTION = "Library Collection:";
    private static final String LIB_USERS = "User Accounts:";
    public static ArrayList<Book> bookList;
    public static HashMap<Integer, User> userList; // userId -> user(object)
    public Library(){
        bookList = new ArrayList<>();
        userList = new HashMap<>();
    }

    public static void addBook(Book book){
        bookList.add(book);
    }

    public static void addUser(User user){
        userList.put(user.getUserId(), user);
    }

    public static void removeBook(Book book){
        bookList.remove(book);
    }

    public static void removeUser(User user){
        // get the array associated with the user. If empty, user is safe to remove. Else, print message to console.
        if(user.getBookList().isEmpty()) {
            userList.remove(user);
        }else {
            System.out.println("Operation Failed: User cannot be removed until all checked out items are returned");
        }
    }

    public void checkOutBookCopy (Integer hash, Integer userID) {
        BookCopy copy = BookCopy.getBookCopyFromHash(hash);
        Book book = BookCopy.getBookFromHash(hash);
        copy.checkOut(hash, userID);
        userList.get(userID).addToBookList(book);

        // add the book associated with this copy.
    }

    public void returnBookCopy (Integer hash) {
        // hash of the object
        // how do without userID?
        BookCopy copy = BookCopy.getBookCopyFromHash(hash);
        Book book = BookCopy.getBookFromHash(hash);
        Integer associatedUser = BookCopy.getUserIdFromHash(hash);
        User user = userList.get(associatedUser);
        copy.returnItem(hash);
        user.removeFromBookList(book);

        // remove the book from User bookList
    }

    public void displayBooks() {
        System.out.println(LIB_COLLECTION);
        for(Book b : bookList){
            b.displayInfo();
        }
    }

    public void displayUsers(){
        System.out.println(LIB_USERS);
        for (User u : userList.values()){
            u.displayUserInfo();
        }
    }
}

abstract class Book {
    private static final String SEPARATOR = "--------------------------------\n";
    protected String title;
    protected String author;
    protected String genre;
    protected String genreLabel;
    protected int year;
    protected int circulating;
    protected ArrayList<Integer> bookHashCollection; // book -> array<hashes>

    protected void displayInfo(){ // with a reasonably large set of books, displaying the id's and checkout Status would// make output strings unreasonably long. This would be accomplished on a per book basis.
        System.out.printf("\tTitle: %s, Author: %s, Year: %s. \n\t%s: %s\n\tTotal Circulating: %d, \n\tTotal Available: %d.\n\t%s",
                title, author, year, genreLabel, genre, bookHashCollection.size(), (bookHashCollection.size() - circulating),SEPARATOR);
    }

    protected Book(String title, String author, int year, String genre, String genreLabel) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.genreLabel = genreLabel;
        bookHashCollection = new ArrayList<>();
    }

    // when BookCopy is called on a Book, add the hash to the collection.
    protected void addHashToCollection(Integer hash){
        bookHashCollection.add(hash);
    }
    protected void checkOut(){ ++circulating;}
    protected void returnItem(){ --circulating;}


}

class Fiction extends Book{
    private static final String GENRE = "Genre";
    public Fiction(String title, String author, int year, String genre) {
        super(title, author, year, genre, GENRE);
    }

    public void displayInfo() {
        super.displayInfo();
    }
}

class NonFiction extends Book{
    private static final String CATEGORY = "Category";
    public NonFiction(String title, String author, int year, String category) {
        super(title, author, year, category,CATEGORY);
    }

    public void displayInfo() {
        super.displayInfo();
    }
}

class User{
    private static final String BOOKS_OUT = "Number of Books Currently Checked Out";
    private static final String SEPARATOR = "--------------------------------\n";
    private final String username;
    private final int userId;
    private ArrayList<Book> bookList;

    public User(String username, int userId){ // passing userID is bad
        this.username = username;
        this.userId = userId;
        bookList = new ArrayList<>();// does not prevent collisions, requires error checking that could be avoided (did not implement)
    }

    public void displayUserInfo(){
        System.out.printf("\tUser ID: %d, Username: %s.\n\t%s: %d.\n\t%s", userId, username, BOOKS_OUT, bookList.size(), SEPARATOR);
    }

    public int getUserId() {
        return userId;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void addToBookList(Book book) {
        bookList.add(book);
    }
    public void removeFromBookList(Book book) {
        bookList.remove(book);
    }
}

// bodged this together. Definitely not the best solution.
class BookCopy implements LibraryItem{
    private static int count = 0;
    private final int instanceCount;
    private int hash;
    private boolean checkedOut;
    // Just put everything in a hashmap. Nonsense.
    private static HashMap<Integer, Integer> hashToUserId = new HashMap<>(); // hash -> userId
    private static HashMap<Integer, Book> hashToBook = new HashMap<>();
    private static HashMap<Integer, BookCopy> hashToBookCopy = new HashMap<>();
    // Try with and without instanceCount to see if uniqueness applies in either case
    public BookCopy(Book book){
        instanceCount = count;
        checkedOut = false;
        hash = this.hashCode();// idk if this works
        hashToBook.put(hash, book);
        hashToBookCopy.put(hash, this);
        book.addHashToCollection(hash);
        ++count;
    }

    public static Book getBookFromHash(Integer hashcode){
        return hashToBook.get(hashcode);
    }

    public static BookCopy getBookCopyFromHash(Integer hashcode) {
        if(hashToBook.containsKey(hashcode)) {
            return  hashToBookCopy.get(hashcode);
        }else{
            return null;
        }
    }

    public static Integer getUserIdFromHash(Integer hashcode) {
        return hashToUserId.get(hashcode);
    }

    @Override
    public void checkOut(Integer hashcode, Integer userId) {
        checkedOut = true;
        hashToUserId.put(hashcode, userId);
        Book book = hashToBook.get(hashcode);
        book.checkOut();
    }

    @Override
    public void returnItem(Integer hashcode) {
        checkedOut = false;
        hashToUserId.remove(hashcode);
        Book book = hashToBook.get(hashcode);
        book.returnItem();
    }
}

interface LibraryItem{
    void checkOut(Integer hashcode, Integer userId);

    void returnItem(Integer hashcode);
}