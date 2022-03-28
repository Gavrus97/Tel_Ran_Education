public class Transaction {

    String uuid;
    String state;
    long sum;
    long date;

    public Transaction(String uuid, String state, long sum, long date) {
        this.uuid = uuid;
        this.state = state;
        this.sum = sum;
        this.date = date;
    }


}
