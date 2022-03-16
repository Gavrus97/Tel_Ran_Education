import operation.IStringOperation;
import java.io.PrintWriter;

public class TexTask implements Runnable {

    private final OperationContext operationContext;
    private final PrintWriter pw;
    private final String line;

    public TexTask(OperationContext operationContext, PrintWriter pw, String line) {
        this.operationContext = operationContext;
        this.pw = pw;
        this.line = line;
    }


    @Override
    public void run() {
        String res = handleLine(line);
        pw.println(res);
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
