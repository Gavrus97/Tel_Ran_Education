import java.util.Scanner;

public class Chars{

    private final Scanner scan;

    public Chars() {
        this.scan = new Scanner(System.in);
    }

    public boolean isDigit(){
        System.out.println("введите символ");
        String a = scan.next();
        char b = a.charAt(0);
        scan.close();
        return b >= 0 && b < 10;
    }
}
