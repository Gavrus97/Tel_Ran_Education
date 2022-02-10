import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class MaxLength {
    public static void main(String[] args) {

        int maxLength = 0;
        String maxString = "";
        String str;

        try {
            FileReader input = new FileReader("input.txt");
            BufferedReader g = new BufferedReader(input);
            Scanner in = new Scanner(g);

            while (in.hasNext()) {
                str = String.valueOf(in.next());
                if(str.length() > maxLength){
                   maxLength = str.length();
                   maxString = str;
                }
            }
            PrintWriter output = new PrintWriter("output.txt");
            output.print(maxString);
            output.close();
            input.close();
            in.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
