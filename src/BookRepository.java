import java.util.ArrayList;
import java.util.Date;

public class BookRepository {
    public static AuthorRepository authorRepository = new AuthorRepository();
    public static ArrayList<Book> books = new ArrayList<>();

    public void createBook(int index, String isbn, String title, Author author, Date publishDate,boolean isAvailable){
        Book book = new Book(isbn,title,author,publishDate,isAvailable);
        books.add(book);AuthorRepository.getAuthors().get(index).getBooks().add(book);
        System.out.println("Successfully created.");
    }
    public void readBook(int listOption){
        switch (listOption){
            case 1:
                System.out.printf("%-5s %-15s %-15s %-15s %-8s\n","#","Title","Author","Isbn","Availability");
                int bookIdAll=0;
                for(Book book:books){
                    bookIdAll++;
                    System.out.printf("%-5s %-15s %-15s %-15s %-8s\n"
                            ,bookIdAll,book.getTitle(),book.getAuthor().getProfile().getLastName(),book.getIsbn()
                    ,book.isAvailable());
                }
                break;
            case 2:
                System.out.printf("%-5s %-15s %-15s %-15s %-8s\n","#","Title","Author","Isbn","Availability");
                int bookIdBorrowed=0;
                for(Book book:books){
                    bookIdBorrowed++;
                    if(!book.isAvailable()){
                        System.out.printf("%-5s %-15s %-15s %-15s %-8s\n"
                                ,bookIdBorrowed,book.getTitle(),book.getAuthor().getProfile().getLastName(),book.getIsbn()
                                ,book.isAvailable());
                    }
                }
                break;
            case 3:
                System.out.printf("%-5s %-15s %-15s %-15s %-8s\n","#","Title","Author","Isbn","Availability");
                int bookIdAvailable=0;
                for(Book book:books){
                    bookIdAvailable++;
                    if(book.isAvailable()){
                        System.out.printf("%-5s %-15s %-15s %-15s %-8s\n"
                                ,bookIdAvailable,book.getTitle(),book.getAuthor().getProfile().getLastName(),book.getIsbn()
                                ,book.isAvailable());
                    }
                }
                break;
        }
    }
    public void updateBook(int index,String isbn,String title,Author author,Date publishDate,boolean isAvailable){
        Book book = new Book(isbn,title,author,publishDate,isAvailable);
        books.set(index,book);
        System.out.println("Successfully updated.");
    }
    public void deleteBook(int index){
        if(!books.get(index).isAvailable()){
            System.out.println("You cannot delete borrowed books.");
        }else{
            for(Author author:authorRepository.getAuthors()){
                author.getBooks().remove(books.remove(index));
            }
            System.out.println("Successfully deleted.");
        }
    }
}
