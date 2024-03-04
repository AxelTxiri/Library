import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ClientRepository {
    public static ArrayList<Client> clients = new ArrayList<>();

    public void createClient(Profile profile, ArrayList<Book>borrowedBooks){
        Client client = new Client(profile, borrowedBooks);
        clients.add(client);
        System.out.println("Successfully created.");
    }
    public void readClient(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
        System.out.printf("%-5s %-10s %-15s %-15s %-10s\n","#","Name","Last Name","Birthdate","Books Title");
        int clientId=0;
        for(Client client:clients){
            clientId++;
            System.out.printf("%-5s %-10s %-15s %-15s %-10s\n"
                    ,clientId,client.getProfile().getName(),client.getProfile().getLastName()
                    ,dateFormat.format(client.getProfile().getBirthdate()),client.getBorrowedBooks().toString());
        }
    }
    public void updateClient(int index, Profile profile){
        Client client = new Client(profile, clients.get(index).getBorrowedBooks());
        clients.set(index,client);
        System.out.println("Successfully updated.");
    }
    public void deleteClient(int index){
        if(!clients.get(index).getBorrowedBooks().isEmpty()){
            System.out.println("Delete Author's books to delete the author.");
        }
        clients.remove(index);
        System.out.println("Successfully deleted.");
    }
}
