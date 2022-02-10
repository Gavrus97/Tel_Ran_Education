import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class MinMax {
    public static void main(String[] args) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int temp;
        int count = 0;
        try {
            FileReader input = new FileReader("input.txt");
            BufferedReader g = new BufferedReader(input);
            Scanner in = new Scanner(g);

            while (in.hasNext()) {
                temp = Integer.parseInt(in.next());
                if (temp > 0 && temp % 2 == 0) {
                    count += 1;
                    if (temp > max)
                        max = temp;
                    if (temp < min)
                        min = temp;
                }
            }
            PrintWriter output = new PrintWriter("output.txt");
            if (count != 0)
                output.printf("%d %d", min, max);
            else
                output.printf("%d", count);
            output.close();
            input.close();
            in.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
