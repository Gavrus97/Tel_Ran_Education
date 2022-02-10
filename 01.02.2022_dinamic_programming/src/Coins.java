import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] array = new int[n + 1];
        for (int i = 0; i <= n ; i++) {
            array[i] = 0;
        }
    }
}
