public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread hashThread = new CharThread('#');
        Thread startThread = new CharThread('*');

        hashThread.start(); //here we open new Thread
        startThread.start(); //here we open new Thread

        hashThread.join(); //заставляет поток из которого вызван join(main Thread) ждать на этом месте, пока не закончится поток из
        // которого вызван join(hashThread)
        startThread.join();

        System.out.println("end of main");
    }
}
