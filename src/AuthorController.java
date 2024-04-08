import java.util.ArrayList;
import java.util.Scanner;

public class AuthorController {
    public static Scanner scanner = new Scanner(System.in);
    public static AuthorRepository authorRepository = new AuthorRepository();
    public static ProfileController profileController = new ProfileController();
    public static int option=0;
    public static void authorOperations(){
        authorMenu();

        do{
            switch (option){
                case 1 :
                    Profile profile = ProfileController.profileBuilder();
                    ArrayList<Book> books = new ArrayList<>();

                    authorRepository.createAuthor(profile,books);

                    authorMenu();
                    break;
                case 2:
                    if(AuthorRepository.authors.isEmpty()){
                        System.out.println("There's no authors to show.");
                        System.out.println();
                    }else{
                        System.out.println("AUTHOR LIST:");
                        authorRepository.readAuthor();
                    }

                    authorMenu();
                    break;
                case 3:
                    if(AuthorRepository.authors.isEmpty()){
                        System.out.println("There's no authors to update.");
                        System.out.println();
                    }else{
                        authorRepository.readAuthor();
                        System.out.println();
                        System.out.println("Enter the # of the Author to edit:");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        index--;

                        Profile updatedProfile = ProfileController.profileBuilder();
                        authorRepository.updateAuthor(index, updatedProfile);
                    }

                    authorMenu();
                    break;
                case 4:
                    if(AuthorRepository.authors.isEmpty()){
                        System.out.println("There's no authors to delete.");
                        System.out.println();
                    }
                    else{
                        authorRepository.readAuthor();
                        System.out.println();
                        System.out.println("Enter the # of the Author to delete:");
                        int deleteIndex = scanner.nextInt();
                        scanner.nextLine();
                        deleteIndex--;
                        authorRepository.deleteAuthor(deleteIndex);
                    }

                    authorMenu();
                    break;
            }
        }while(option!=5);
    }
    public static void authorMenu(){
        System.out.println("*******************************");
        System.out.println("*         AUTHOR MENU         *");
        System.out.println("*******************************");
        System.out.println("*       1.Create Author       *");
        System.out.println("*       2.Read Authors        *");
        System.out.println("*       3.Update Author       *");
        System.out.println("*       4.Delete Author       *");
        System.out.println("*       5.Main Menu           *");
        System.out.println("*******************************");

        System.out.println("Enter your option:");
        do{
            option = scanner.nextInt();
            if (option<1||option>5){
                System.out.println("Enter a valid option:");
            }
        }while(option<1||option>5);
        System.out.println();
    }
}
