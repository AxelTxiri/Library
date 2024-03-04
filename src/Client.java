import java.util.ArrayList;

public class Client {
    private Profile profile;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Client() {
    }

    public Client(Profile profile, ArrayList<Book> borrowedBooks) {
        this.profile = profile;
        this.borrowedBooks = borrowedBooks;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
