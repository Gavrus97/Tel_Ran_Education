import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {

        int kol = 0;
        double sum = 0;

        try {
            FileReader input = new FileReader("input.txt");
            BufferedReader g = new BufferedReader(input);
            Scanner in = new Scanner(g);

            while(in.hasNext()){
                sum += Integer.parseInt(in.next());
                kol = kol + 1;
            }
            sum = sum / kol;

            PrintWriter output = new PrintWriter("output.txt");
            output.printf("%.3f",sum);
            output.close();
            input.close();
            in.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
