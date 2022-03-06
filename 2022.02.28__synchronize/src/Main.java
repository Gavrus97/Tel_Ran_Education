public class Main {

    public static void main(String[] args) throws InterruptedException {

        IntegerWrapper wrapper = new IntegerWrapper();
        IntegerWrapper wrapper2 = new IntegerWrapper();

        IncrementerRunnable incrementerRunnable1 = new IncrementerRunnable(wrapper, 10000000);
        IncrementerRunnable incrementerRunnable2 = new IncrementerRunnable(wrapper, 10000000);
        IncrementerRunnable incrementerRunnable3 = new IncrementerRunnable(wrapper2, 10000000);
        IncrementerRunnable incrementerRunnable4 = new IncrementerRunnable(wrapper2, 10000000);

        Thread th1 = new Thread(incrementerRunnable1);
        Thread th2 = new Thread(incrementerRunnable2);
        Thread th3 = new Thread(incrementerRunnable3);
        Thread th4 = new Thread(incrementerRunnable4);

        long startTime = System.currentTimeMillis();

        th1.start();
        th2.start();
        th3.start();
        th4.start();

        th1.join();
        th2.join();
        th3.join();
        th4.join();

        System.out.println(System.currentTimeMillis() - startTime);

        System.out.println(wrapper.getNumber());
        System.out.println(wrapper2.getNumber());
    }
}
