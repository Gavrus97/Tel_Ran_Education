import java.io.FileOutputStream;
import java.io.IOException;


    public class ExampleOutput2 {
        final static String FILE_NAME = "Output.txt";

        public static void main(String[] args) throws IOException {
            String hello = "Hello world!\u03A9";
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME, true);

            outputStream.write(hello.getBytes());
            outputStream.close();
        }
    }
