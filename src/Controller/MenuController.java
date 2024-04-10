package Controller;

import java.util.Scanner;

public class MenuController {
    public static Scanner scanner = new Scanner(System.in);
    public static int option = 0;

    public static void mainOperations() {
        mainMenu();
        do {
            switch (option) {
                case 1:
                    BookController bookController = new BookController();
                    BookController.bookOperations();
                    mainMenu();
                    break;
                case 2:
                    ClientController clientController = new ClientController();
                    ClientController.clientOperations();
                    mainMenu();
                    break;
                case 3:
                    AuthorController authorController = new AuthorController();
                    AuthorController.authorOperations();
                    mainMenu();
                    break;
                case 4:
                    TransactionController transactionController = new TransactionController();
                    TransactionController.transactionOperations();
                    mainMenu();
                    break;
                case 5:
                    AdministratorController administratorController = new AdministratorController();
                    AdministratorController.adminOperations();
                    mainMenu();
                    break;
            }
        } while (option != 6);
    }

    public static void mainMenu() {
        System.out.println("*******************************");
        System.out.println("*          MAIN MENU          *");
        System.out.println("*******************************");
        System.out.println("*        1.Book Menu          *");
        System.out.println("*        2.Client Menu        *");
        System.out.println("*        3.Author Menu        *");
        System.out.println("*        4.Transaction Menu   *");
        System.out.println("*        5.Admins Menu        *");
        System.out.println("*        5.Exit               *");
        System.out.println("*******************************");

        System.out.println("Enter your option:");
        do {
            option = scanner.nextInt();
            if (option < 1 || option > 6) {
                System.out.println("Enter a valid option:");
            }
        } while (option < 1 || option > 6);
        System.out.println();
    }
}
