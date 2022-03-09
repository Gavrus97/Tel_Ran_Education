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
            String line;
            while((line = br.readLine()) != null){
                queue.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
