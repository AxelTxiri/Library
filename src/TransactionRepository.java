import java.util.ArrayList;
import java.util.Date;

public class TransactionRepository {
    public static ArrayList<Transaction> transactions = new ArrayList<>();

    public void createTransaction(String id, String type, Client client, Book book, Date date) {
        transactions.add(new Transaction(id, type, client, book, date));
        System.out.println("Successfully created.");
    }
}
