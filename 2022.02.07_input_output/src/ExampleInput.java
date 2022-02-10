import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ExampleInput {
    public static void main(String[] args) {
        FileInputStream input = null;
        try {
            input = new FileInputStream("input.txt");
            int code = input.read();
            System.out.println(code + " char = " + (char)code);
            byte[] arr = new byte[16];
            int numberBytes = input.read(arr);
            System.out.println("numberBytes = " + numberBytes);
            System.out.println(Arrays.toString(arr));
            // input.close(); // wrong
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
