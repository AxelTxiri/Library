package Controller;

import Model.*;

import java.util.Scanner;
import java.rmi.server.UID;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TransactionController {
    public static int option = 0;
    public static Scanner scanner = new Scanner(System.in);
    public static ClientRepository clientRepository = new ClientRepository();
    public static BookRepository bookRepository = new BookRepository();
    public static int indexClient = 0;
    public static int indexBook = 0;
    public static TransactionRepository transactionRepository = new TransactionRepository();

    public static void transactionOperations() {
        transactionMenu();
        do {
            switch (option) {
                case 1:
                    borrowBook();
                    transactionMenu();
                    break;
                case 2:
                    returnBook();
                    transactionMenu();
                    break;
                case 3:
                    reportsMenu();
                    do {
                        switch (option) {
                            case 1:
                                dateFilteredReport();
                                reportsMenu();
                                break;
                            case 2:
                                clientFilteredReport();
                                reportsMenu();
                                break;
                            case 3:
                                bookFilteredReport();
                                reportsMenu();
                                break;
                        }
                    } while (option != 4);

                    transactionMenu();
                    break;
            }
        } while (option != 4);
    }

    public static void transactionMenu() {
        option = 0;
        System.out.println("**********************************");
        System.out.println("*       TRANSACTION MENU         *");
        System.out.println("**********************************");
        System.out.println("*       1.Borrow Books           *");
        System.out.println("*       2.Return Books           *");
        System.out.println("*       3.Transactions Report    *");
        System.out.println("*       4.Main Menu              *");
        System.out.println("**********************************");

        System.out.println("Enter your option:");
        do {
            option = scanner.nextInt();
            if (option < 1 || option > 4) {
                System.out.println("Enter a valid option:");
            }
        } while (option < 1 || option > 4);
        System.out.println();
    }

    public static void reportsMenu() {
        option = 0;
        System.out.println("**********************************");
        System.out.println("*       TRANSACTION REPORT       *");
        System.out.println("**********************************");
        System.out.println("*       1.Filtered by date       *");
        System.out.println("*       2.Filtered by client     *");
        System.out.println("*       3.Filtered by book       *");
        System.out.println("*       4.Main Menu              *");
        System.out.println("**********************************");

        System.out.println("Enter your option:");
        do {
            option = scanner.nextInt();
            if (option < 1 || option > 4) {
                System.out.println("Enter a valid option:");
            }
        } while (option < 1 || option > 4);
        System.out.println();
    }
    public static void dateFilteredReport(){
        System.out.println("Enter the time range of the transactions:(dd-MM-yyyy)");
        scanner.nextLine();
        System.out.println("Lower limit:");
        Date startDate = DateController.dateInput();
        System.out.println("Upper limit:");
        Date endDate = DateController.dateInput();

        for (Transaction transaction : TransactionRepository.transactions) {
            if(!transaction.getDate().after(startDate) && !transaction.getDate().before(endDate)){
                System.out.println("There is not transactions during dates given");
                break;
            }else{
                System.out.println("Transactions between " + startDate + " and " + endDate + ":");
                System.out.println();
                System.out.printf("%-30s %-15s %-25s %-25s\n","Model.Transaction ID","Model.Client","Type of transaction","Model.Book title","Date");
            }
        }
        for (Transaction transaction : TransactionRepository.transactions) {
            if(transaction.getDate().after(startDate) && transaction.getDate().before(endDate)){
                System.out.printf("%-30s %-15s %-25s %-25s %-25s\n",transaction.getId(),
                        transaction.getClient().getProfile().getName(),transaction.getType(),
                        transaction.getBook().getTitle(),transaction.getDate());
            }
        }
        System.out.println();
    }
    public static void clientFilteredReport(){
        clientRepository.readClient();
        System.out.println("Enter the name of the client you want to see the transactions:");
        scanner.nextLine();
        String client = scanner.nextLine();

        for (Transaction transaction : TransactionRepository.transactions) {
            if(!transaction.getClient().getProfile().getName().equals(client)){
                System.out.println("The client has not made any transaction.");
                break;
            }else{
                System.out.println("Transactions of the client " + client + ":");
                System.out.println();
                System.out.printf("%-30s %-15s %-25s %-25s\n","Model.Transaction ID","Model.Client","Type of transaction","Model.Book title","Date");
            }
        }
        for (Transaction transaction : TransactionRepository.transactions) {
            if(transaction.getClient().getProfile().getName().equals(client)){
                System.out.printf("%-30s %-15s %-25s %-25s %-25s\n",transaction.getId(),
                        transaction.getClient().getProfile().getName(),transaction.getType(),
                        transaction.getBook().getTitle(),transaction.getDate());
            }
        }
        System.out.println();
    }
    public static void bookFilteredReport(){
        bookRepository.readBook(1);
        System.out.println("Enter the name of the book you want to see the transactions:");
        scanner.nextLine();
        String book = scanner.nextLine();

        for (Transaction transaction : TransactionRepository.transactions) {
            if(!transaction.getBook().getTitle().equals(book)){
                System.out.println("The book has not made any transaction.");
                break;
            }else{
                System.out.println("Transactions of the client " + book + ":");
                System.out.println();
                System.out.printf("%-30s %-25s %-25s %-25s\n","Model.Transaction ID","Model.Book title","Type of transaction","Model.Client","Date");
            }
        }
        for (Transaction transaction : TransactionRepository.transactions) {
            if(transaction.getBook().getTitle().equals(book)){
                System.out.printf("%-30s %-25s %-25s %-25s %-25s\n",transaction.getId(),
                        transaction.getBook().getTitle(),transaction.getType(),
                        transaction.getClient().getProfile().getName(),transaction.getDate());
            }
        }
        System.out.println();
    }
    public static void transactionGenerator(String type, int indexClient, int indexBook) {
        UID uid = new UID();
        String uniqueID = uid.toString();

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);

        transactionRepository.createTransaction(uniqueID, type, ClientRepository.clients.get(indexClient)
                , BookRepository.books.get(indexBook), currentDate);
    }
    public static void borrowBook() {
        indexClient = 0;
        indexBook = 0;
        System.out.printf("%-5s %-10s %-15s\n", "#", "Name", "Last Name");
        int clientId = 0;
        for (Client client : ClientRepository.clients) {
            clientId++;
            System.out.printf("%-5s %-10s %-15s\n"
                    , clientId, client.getProfile().getName(), client.getProfile().getLastName());
        }
        System.out.println();
        System.out.println("Enter the # of the Model.Client to borrow them a book:");
        indexClient = scanner.nextInt();
        scanner.nextLine();
        indexClient--;

        if (ClientRepository.clients.get(indexClient).getBorrowedBooks().size() >= 3) {
            System.out.println("Each client can only have 3 books.");
        } else {
            System.out.printf("%-5s %-15s %-8s\n", "#", "Title", "Availability");
            int bookIdAll = 0;
            for (Book book : BookRepository.books) {
                bookIdAll++;
                System.out.printf("%-5s %-15s %-15s\n"
                        , bookIdAll, book.getTitle(), book.isAvailable());
            }
            System.out.println();
            System.out.println("Enter the # of the book to borrow:");
            indexBook = scanner.nextInt();
            scanner.nextLine();
            indexBook--;

            if (BookRepository.books.get(indexBook).isAvailable()) {
                ClientRepository.clients.get(indexClient).getBorrowedBooks().add(BookRepository.books.get(indexBook));
                BookRepository.books.get(indexBook).setAvailable(false);
                String type1 = "Borrow";
                transactionGenerator(type1, indexClient, indexBook);
            } else {
                System.out.println("Model.Book not available.");
            }
        }
        System.out.println();
    }
    private static void returnBook() {
        indexClient = 0;
        indexBook = 0;
        System.out.printf("%-5s %-10s %-15s %-25s\n", "#", "Name", "Last Name", "Borrowed Books");
        int clientId = 0;
        for (Client client : ClientRepository.clients) {
            clientId++;
            System.out.printf("%-5s %-10s %-15s %-25s"
                    , clientId, client.getProfile().getName(), client.getProfile().getLastName(), "Borrowed Books:");
            for (Book book : client.getBorrowedBooks()) {
                System.out.print(book.getTitle() + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Enter the # of the Model.Client who is retuning a book:");
        indexClient = scanner.nextInt();
        scanner.nextLine();
        indexClient--;

        if (ClientRepository.clients.get(indexClient).getBorrowedBooks().isEmpty()) {
            System.out.println("This client does not have any book to return.");
        } else {
            System.out.printf("%-5s %-15s %-15s\n", "#", "Title", "Model.Author");
            int bookIdAll = 0;
            for (Book book : ClientRepository.clients.get(indexClient).getBorrowedBooks()) {
                bookIdAll++;
                System.out.printf("%-5s %-15s %-15s\n"
                        , bookIdAll, book.getTitle(), book.getAuthor().getProfile().getLastName());
            }
            System.out.println();
            System.out.println("Enter the # of the book to return:");
            indexBook = scanner.nextInt();
            scanner.nextLine();
            indexBook--;

            ClientRepository.clients.get(indexClient).getBorrowedBooks().get(indexBook).setAvailable(true);
            ClientRepository.clients.get(indexClient).getBorrowedBooks().remove(indexBook);

            String type2 = "Return";
            transactionGenerator(type2, indexClient, indexBook);
        }
        System.out.println();
    }
}
