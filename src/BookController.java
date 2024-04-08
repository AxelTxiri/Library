import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BookController {
    public static Scanner scanner = new Scanner(System.in);
    public static BookRepository bookRepository = new BookRepository();
    public static DateController dateController = new DateController();
    public static AuthorRepository authorRepository = new AuthorRepository();
    public static int option=0;
    public static int listOption=0;
    public static int index=0;
    public static void bookOperations(){
        bookMenu();

        do{
            switch (option){
                case 1 :
                    if(!authorRepository.getAuthors().isEmpty()){
                        System.out.println("Enter isbn:");
                        String isbn = scanner.nextLine();
                        System.out.println("Enter title:");
                        String title = scanner.nextLine();
                        Author author = authorSelection();
                        System.out.println("Publish date:");
                        Date publishDate = dateController.dateInput();
                        boolean isAvailable = true;

                        bookRepository.createBook(index,isbn,title,author,publishDate,isAvailable);
                    }else{
                        System.out.println("You need to create an Author to create a book.");
                    }
                    index=0;

                    bookMenu();
                    break;
                case 2:
                    if(BookRepository.books.isEmpty()){
                        System.out.println("There's no books to read.");
                        System.out.println();
                    }
                    else{
                        listOption = readMenu(listOption);
                        bookRepository.readBook(listOption);
                    }

                    bookMenu();
                    break;
                case 3:
                    if(BookRepository.books.isEmpty()){
                        System.out.println("There's no books to update.");
                        System.out.println();
                    }
                    else{
                        bookRepository.readBook(1);
                        System.out.println();
                        System.out.println("Enter the # of the Author to edit:");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        index--;

                        System.out.println("Enter isbn:");
                        String isbnUpdate = scanner.nextLine();
                        System.out.println("Enter title:");
                        String titleUpdate = scanner.nextLine();
                        Author authorUpdate = authorSelection();
                        System.out.println("Publish date:");
                        Date publishDateUpdate = dateController.dateInput();
                        boolean isAvailableUpdate = true;

                        bookRepository.updateBook(index,isbnUpdate,titleUpdate,authorUpdate
                                ,publishDateUpdate,isAvailableUpdate);
                    }

                    bookMenu();
                    break;
                case 4:
                    if(BookRepository.books.isEmpty()){
                        System.out.println("There's no books to delete.");
                        System.out.println();
                    }
                    else{
                        bookRepository.readBook(1);
                        System.out.println();
                        System.out.println("Enter the # of the Book to delete:");
                        int deleteIndex = scanner.nextInt();
                        scanner.nextLine();
                        deleteIndex--;
                        bookRepository.deleteBook(deleteIndex);
                        deleteIndex = 0;
                    }

                    bookMenu();
                    break;
            }
        }while(option!=5);
    }

    public static void bookMenu(){
        System.out.println("*******************************");
        System.out.println("*          BOOK MENU          *");
        System.out.println("*******************************");
        System.out.println("*       1.Create Book         *");
        System.out.println("*       2.Read Books          *");
        System.out.println("*       3.Update Book         *");
        System.out.println("*       4.Delete Book         *");
        System.out.println("*       5.Main Menu           *");
        System.out.println("*******************************");

        System.out.println("Enter your option:");
        do{
            option = scanner.nextInt();
            scanner.nextLine();
            if (option<1||option>5){
                System.out.println("Enter a valid option:");
            }
        }while(option<1||option>5);
        System.out.println();
    }
    private static Author authorSelection() {
        authorRepository.readAuthor();
        System.out.println("Enter the # of the Author of the book:");


        do{
            index = scanner.nextInt();
            scanner.nextLine();
            if(index<0||index> AuthorRepository.getAuthors().size()){
                System.out.println("Enter a valid Author #:");
            }
        }while(index<0||index> AuthorRepository.getAuthors().size());
        index--;

        return AuthorRepository.getAuthors().get(index);
    }
    private static int readMenu(int listOption){
        System.out.println("********************************");
        System.out.println("*        BOOK LIST MENU        *");
        System.out.println("********************************");
        System.out.println("*       1.All Books            *");
        System.out.println("*       2.Borrowed Book        *");
        System.out.println("*       3.Available Books      *");
        System.out.println("*       4.Book Menu            *");
        System.out.println("********************************");

        System.out.println("Enter your option:");
        do{
            listOption = scanner.nextInt();
            if (listOption<1||listOption>4){
                System.out.println("Enter a valid option:");
            }
        }while(listOption<1||listOption>4);
        System.out.println();

        return listOption;
    }
}
