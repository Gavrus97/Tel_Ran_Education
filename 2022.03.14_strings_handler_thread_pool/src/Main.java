import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        //create a print writer which is shared among all the consumers
        try (PrintWriter pw = new PrintWriter("output2.txt")) {

            //load operations
            List<String> operationsPaths = getOperationsPaths("program.props");
            OperationContext operationContext = new OperationContext();
            operationContext.loadOperations(operationsPaths);

            ExecutorService executorService = Executors.newFixedThreadPool(3);

            try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    executorService.execute(new TexTask(operationContext, pw, line));
                }
            }

            executorService.shutdown();
            executorService.awaitTermination(800, TimeUnit.NANOSECONDS);
        }
    }

        private static List<String> getOperationsPaths (String s) throws IOException {
            Properties properties = new Properties();
            properties.load(new FileReader(s));
            String str = properties.getProperty("paths");
            return Arrays.asList(str.split(","));
        }
    }