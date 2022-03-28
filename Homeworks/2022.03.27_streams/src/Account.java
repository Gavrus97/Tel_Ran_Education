import java.util.List;

public class Account {

    String uuid;
    long balance;
    List<Transaction> transactions;

    public Account(String uuid, long balance, List<Transaction> transactions) {
        this.uuid = uuid;
        this.balance = balance;
        this.transactions = transactions;
    }
}
