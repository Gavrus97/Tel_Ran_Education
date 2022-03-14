import operations.IStringOperation;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class TextConsumer extends Thread {

    private final BlockingQueue<String> queue;
    private final OperationContext operationContext;
    private final PrintWriter pw;
    private Thread nextConsumerThread;

    public void setNextConsumerThread(Thread nextConsumerThread) {
        this.nextConsumerThread = nextConsumerThread;
    }

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

                if(line.equals("exit")){
                    nextConsumerThread.interrupt();
                    return;
                }

                String newLine = handleLine(line);
                pw.println(newLine);
            }
        } catch (InterruptedException e) {
            nextConsumerThread.interrupt();
            System.err.println(Thread.currentThread().getName() + " interrupted");
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
