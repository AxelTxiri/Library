import java.util.Scanner;

public class TransactionController {
    public static int option = 0;
    public static Scanner scanner = new Scanner(System.in);
    public static ClientRepository clientRepository = new ClientRepository();
    public static void transactionOperations() {
        transactionMenu();
        switch (option){
            case 1:
                borrowBook();
                transactionMenu();
                break;
            case 2:
                returnBook();
                transactionMenu();
                break;
        }
    }

    public static void transactionMenu(){
        System.out.println("********************************");
        System.out.println("*       TRANSACTION MENU       *");
        System.out.println("********************************");
        System.out.println("*       1.Return Books         *");
        System.out.println("*       2.Borrow Books         *");
        System.out.println("*       3.Main Menu            *");
        System.out.println("********************************");

        System.out.println("Enter your option:");
        do{
            option = scanner.nextInt();
            if (option<1||option>3){
                System.out.println("Enter a valid option:");
            }
        }while(option<1||option>3);
        System.out.println();
    }
    public static void borrowBook(){
        System.out.printf("%-5s %-10s %-15s %-15s %-10s\n","#","Name","Last Name");
        int clientId=0;
        for(Client client: ClientRepository.clients){
            clientId++;
            System.out.printf("%-5s %-10s %-15s %-15s %-10s\n"
                    ,clientId,client.getProfile().getName(),client.getProfile().getLastName());
        }
        System.out.println();
        System.out.println("Enter the # of the Client to borrow them a book:");
        int indexClient = scanner.nextInt();
        scanner.nextLine();
        indexClient--;

        if(ClientRepository.clients.get(indexClient).getBorrowedBooks().size()>=3){
            System.out.println("Each client can only have 3 books.");
        }else{
            System.out.printf("%-5s %-15s %-15s %-15s %-8s\n","#","Title","Author","Isbn","Availability");
            int bookIdAll=0;
            for(Book book: BookRepository.books){
                bookIdAll++;
                System.out.printf("%-5s %-15s %-15s %-15s %-8s\n"
                        ,bookIdAll,book.getTitle(),book.isAvailable());
            }
            System.out.println();
            System.out.println("Enter the # of the book to borrow:");
            int indexBook = scanner.nextInt();
            scanner.nextLine();
            indexBook--;

            if(BookRepository.books.get(indexBook).isAvailable()){
                ClientRepository.clients.get(indexClient).getBorrowedBooks().add(BookRepository.books.get(indexBook));
                BookRepository.books.get(indexBook).setAvailable(false);
            }
            else {
                System.out.println("Book not available.");
            }
        }
        System.out.println();

    }
    private static void returnBook() {
        System.out.printf("%-5s %-10s %-15s %-25s\n","#","Name","Last Name","Borrowed Books");
        int clientId=0;
        for(Client client: ClientRepository.clients){
            clientId++;
            System.out.printf("%-5s %-10s %-15s %-25s\n"
                    ,clientId,client.getProfile().getName(),client.getProfile().getLastName(),"Borrowed Books:");
            for (Book book : client.getBorrowedBooks()) {
                System.out.println(book+"   ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Enter the # of the Client who is retuning a book:");
        int indexClient = scanner.nextInt();
        scanner.nextLine();
        indexClient--;

        if(ClientRepository.clients.get(indexClient).getBorrowedBooks().isEmpty()){
            System.out.println("This client does not have any book to return.");
        }else{
            System.out.printf("%-5s %-15s %-15s %-15s %-8s\n","#","Title","Author","Isbn","Availability");
            int bookIdAll=0;
            for(Book book: ClientRepository.clients.get(indexClient).getBorrowedBooks()){
                bookIdAll++;
                System.out.printf("%-5s %-15s %-15s %-15s %-8s\n"
                        ,bookIdAll,book.getTitle(),book.isAvailable());
            }
            System.out.println();
            System.out.println("Enter the # of the book to return:");
            int indexBook = scanner.nextInt();
            scanner.nextLine();
            indexBook--;

            ClientRepository.clients.get(indexClient).getBorrowedBooks().get(indexBook).setAvailable(true);
            ClientRepository.clients.get(indexClient).getBorrowedBooks().remove(indexBook);

        }
        System.out.println();
    }
}
