import java.util.Scanner;

public class SolutionPairs {
    public static void main(String[] args) {
        countPairs();
    }

    public static void countPairs() {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int res = 0;

            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                scan = new Scanner(System.in);
                array[i] = scan.nextInt();
            }

            for (int i = 1; i < array.length - 1; i++) {
                if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                    res += 1;
                }
            }
        System.out.println(res);
    }
}
