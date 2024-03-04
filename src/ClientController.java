import java.util.ArrayList;
import java.util.Scanner;

public class ClientController {
    public static Scanner scanner = new Scanner(System.in);
    public static ClientRepository clientRepository = new ClientRepository();
    public static ProfileController profileController = new ProfileController();
    public static int option=0;
    public static void clientOperations(){
        clientMenu();

        do{
            switch (option){
                case 1 :
                    Profile profile = ProfileController.profileBuilder();
                    ArrayList<Book> borrowedBooks = new ArrayList<>();

                    clientRepository.createClient(profile,borrowedBooks);

                    clientMenu();
                    break;
                case 2:
                    System.out.println("CLIENT LIST:");
                    clientRepository.readClient();
                    clientMenu();
                    break;
                case 3:
                    clientRepository.readClient();
                    System.out.println();
                    System.out.println("Enter the # of the Client to edit:");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    index--;

                    Profile updatedProfile = ProfileController.profileBuilder();
                    clientRepository.updateClient(index, updatedProfile);
                    clientMenu();
                    break;
                case 4:
                    if(ClientRepository.clients.isEmpty()){
                        System.out.println("There's no clients to delete.");
                        System.out.println();
                    }
                    else{
                        clientRepository.readClient();
                        System.out.println();
                        System.out.println("Enter the # of the Client to delete:");
                        int deleteIndex = scanner.nextInt();
                        scanner.nextLine();
                        deleteIndex--;
                        clientRepository.deleteClient(deleteIndex);
                    }

                    clientMenu();
                    break;
            }
        }while(option!=5);
    }
    public static void clientMenu(){
        System.out.println("*******************************");
        System.out.println("*         CLIENT MENU         *");
        System.out.println("*******************************");
        System.out.println("*       1.Create Client       *");
        System.out.println("*       2.Read Clients        *");
        System.out.println("*       3.Update Client       *");
        System.out.println("*       4.Delete Client       *");
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
