import java.util.Scanner;

public class DangerExplosion2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] array = new int[n + 2];
        array[0] = 0;
        array[1] = 3;
        array[2] = 8;
        for (int i = 3; i <= n; i++) {
            array[i] = 2 * (array[i - 1] + array[i - 2]);
        }
        System.out.println(array[n]);
    }
}
