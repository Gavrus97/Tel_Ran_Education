import java.io.PrintStream;

public class ExamplePrintf {
    public static void main(String[] args) {

        try {
            PrintStream output = new PrintStream("outputF.txt");

            int age = 25;

            output.printf("I am %d years old.", age);
            output.close();
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }
}
