public class IntegerWrapper {

    private int number;

    private final Object mu = new Object();

    public void increment(){
        synchronized (mu){
            number++;
        }
    }

    public void decrement(){
        synchronized (mu){
            number--;
        }
    }

    public int getNumber() {
        return number;
    }
}
