public class Account {

    private final int id;
    private final double balance;
    private final boolean isLocked;

    @Override
    public String toString() {
        return "{ Account " +
                id +
                ", balance=" + balance +
                ", isLocked=" + isLocked
                + " }";
    }


    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return isLocked;
    }


    public Account(int id, double balance, boolean isLocked) {
        this.id = id;
        this.balance = balance;
        this.isLocked = isLocked;
    }
}
