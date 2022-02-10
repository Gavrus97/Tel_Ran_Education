import java.util.Scanner;

public class Stairs {

    private final Scanner scan;

    public Stairs() {
        this.scan = new Scanner(System.in);
    }

    public int count() {
        System.out.println("количество ступеней");
        int n = scan.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("введите слудущее число");
            array[i] = scan.nextInt();
        }

        for (int i = 2; i < n ; i++) {
            array[i] = array[i] + Math.min(array[i - 1], array[i - 2]);
        }
        return array[n - 1];
    }
}
