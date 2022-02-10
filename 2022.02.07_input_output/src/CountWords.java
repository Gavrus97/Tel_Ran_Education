import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {

        int count = 0;
        String str;

        try {
            FileReader input = new FileReader("input.txt");
            BufferedReader g = new BufferedReader(input);
            Scanner in = new Scanner(g);

            while (in.hasNext()){
                str = String.valueOf(in.next());
                count++;
            }
            PrintWriter output = new PrintWriter("output.txt");
            output.printf("%d",count);
            output.close();
            input.close();
            in.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
