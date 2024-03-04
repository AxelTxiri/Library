import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AuthorRepository {
    public static ArrayList<Author> authors = new ArrayList<>();

    public static ArrayList<Author> getAuthors() {
        return authors;
    }

    public void createAuthor(Profile profile, ArrayList<Book>books){
        Author author = new Author(profile, books);
        authors.add(author);
        System.out.println("Successfully created.");
    }
    public void readAuthor(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
        System.out.printf("%-5s %-10s %-15s %-15s %-10s\n","#","Name","Last Name","Birthdate","Books Title");
        int authorId=0;
        for(Author author:authors){
            authorId++;
            System.out.printf("%-5s %-10s %-15s %-15s %-10s"
                    ,authorId,author.getProfile().getName(),author.getProfile().getLastName()
                    ,dateFormat.format(author.getProfile().getBirthdate()),author.getBooks(),"Books:");
            for (Book book : author.getBooks()) {
                System.out.print(book+"  ");
            }
            System.out.println();
        }
    }
    public void updateAuthor(int index, Profile profile){
        Author author = new Author(profile, authors.get(index).getBooks());
        authors.set(index,author);
        System.out.println("Successfully updated.");
    }
    public void deleteAuthor(int index){
        if(authors.get(index).getBooks().isEmpty()){
            System.out.println("Delete Author's books to delete the author.");
        }
        authors.remove(index);
        System.out.println("Successfully deleted.");
    }
}
