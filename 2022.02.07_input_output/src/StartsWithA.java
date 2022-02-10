import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class StartsWithA {
    public static void main(String[] args) {

        int maxLength = 0;
        String maxString = "";
        String str;

        try {
            FileReader input = new FileReader("input.txt");
            BufferedReader g = new BufferedReader(input);
            Scanner in = new Scanner(g);
            PrintWriter output = new PrintWriter("output.txt");

            while (in.hasNextLine()) {
                str = String.valueOf(in.nextLine());
                String[] strArray = str.split(" ");
                for (int i = 0; i < strArray.length; i++) {
                    if(strArray[i].startsWith("A") || strArray[i].startsWith("a")){
                        output.print(str);
                        break;
                    }
                }
            }

            output.close();
            input.close();
            in.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
