public class ConsumerTask implements Runnable{

    private final SingleStringQueue queue;

    public ConsumerTask(SingleStringQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            // хотим чтобы в этом месте поток засыпал если очередь пуста.
            try {
                String line = queue.remove();
                System.out.println("Thread: "+ Thread.currentThread().getName() + ": " + line);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
