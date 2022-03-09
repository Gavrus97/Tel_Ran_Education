import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class TextSupplier implements Runnable {

    private final String fileName;
    private final BlockingQueue<String> queue;

    public TextSupplier(String fileName, BlockingQueue<String> queue) {
        this.fileName = fileName;
        this.queue = queue;
    }


    @Override
    public void run() {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            // TODO read lines from the file one by one and place them into the queue
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
