import java.util.Scanner;

public class WordsCount {

    private final Scanner scan;

    public WordsCount() {
        this.scan = new Scanner(System.in);
    }

    public int count(){
        String str = scan.nextLine();
        String[] array = str.split(" ");
        scan.close();
        return array.length;
    }
}
