public class Account_Exercise7 {

    String uuid;
    long sum;
    boolean isLocked;

    public Account_Exercise7(String uuid, long sum, boolean isLocked) {
        this.uuid = uuid;
        this.sum = sum;
        this.isLocked = isLocked;
    }

    public void lock(){
        this.isLocked = true;
    }
}
