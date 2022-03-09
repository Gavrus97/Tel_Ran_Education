import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) throws IOException {

            //create a print writer which is shared among all the consumers
        try (PrintWriter pw = new PrintWriter("output2.txt")) {

            //load operations
            List<String> operationsPaths = getOperationsPaths("program.props");
            OperationContext operationContext = new OperationContext();
            operationContext.loadOperations(operationsPaths);

            //create blocking queue
            BlockingQueue<String> queue = new LinkedBlockingQueue<>();

            // create and start supplier
            TextSupplier textSupplier = new TextSupplier("input.txt", queue);
            new Thread(textSupplier).start();

            //create and start several consumers
            TextConsumer consumer1 = new TextConsumer(queue, operationContext, pw);
            TextConsumer consumer2 = new TextConsumer(queue, operationContext, pw);
            TextConsumer consumer3 = new TextConsumer(queue, operationContext, pw);

            new Thread(consumer1).start();
            new Thread(consumer2).start();
            new Thread(consumer3).start();
        }
    }

    private static List<String> getOperationsPaths(String s) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(s));
        String str = properties.getProperty("paths");
        return Arrays.asList(str.split(","));
    }
}