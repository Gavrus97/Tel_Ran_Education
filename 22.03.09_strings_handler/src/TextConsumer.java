import operations.IStringOperation;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class TextConsumer implements Runnable {

    private final BlockingQueue<String> queue;
    private final OperationContext operationContext;
    private final PrintWriter pw;


    public TextConsumer(BlockingQueue<String> queue, OperationContext operationContext, PrintWriter pw) {
        this.queue = queue;
        this.operationContext = operationContext;
        this.pw = pw;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String line = queue.take();
                String newLine = handleLine(line);
                pw.println(newLine);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String handleLine(String line) {

        String[] splitArray = line.split("#");
        String operationName;
        String text;

        if (splitArray.length != 2)
            return line.concat("#wrong operation");
        else {
            operationName = splitArray[0];
            text = splitArray[1];
        }

        IStringOperation operation = operationContext.getOperation(operationName);

        if(operation == null)
            return operationName.concat("#operation not supported");
        else {
            return operation.operate(text);
        }
    }
}
