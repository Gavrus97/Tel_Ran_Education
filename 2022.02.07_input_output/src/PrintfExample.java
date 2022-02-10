import java.io.PrintWriter;
import java.util.Scanner;

public class PrintfExample {
    public static void main(String[] args) {
        try {
            PrintWriter output = new PrintWriter("output7.txt");
            Scanner scan = new Scanner(System.in);
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            int d = a + b + c;
            int e= a * b * c;
            float f = d/3f;

            output.printf("%d+%d+%d=%d", a, b, c, d);
            output.printf("%n");
            output.printf("%d*%d*%d=%d", a, b, c, e);
            output.printf("%n");
            output.printf("(%d+%d+%d)/3=%.3f", a, b, c, f);
            output.close();
        } catch(Exception e){
            e.getStackTrace();
        }
    }
}
