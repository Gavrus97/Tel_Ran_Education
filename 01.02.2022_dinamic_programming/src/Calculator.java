import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();


        int[] array = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            array[i] = 100000;
        }
        array[0] = 0;
        array[1] = 0;

        for (int i = 2; i <= n; i++) {
            if (i % 3 == 0)
                array[i] = Math.min(array[i / 3] + 1, array[i]);
            if (i % 2 == 0)
                array[i] = Math.min(array[i / 2] + 1, array[i]);
            array[i] = Math.min(array[i], array[i - 1] + 1);
        }
        System.out.println(array[n]);
    }
}
