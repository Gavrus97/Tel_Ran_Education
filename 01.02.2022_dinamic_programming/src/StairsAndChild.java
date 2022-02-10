import java.util.Scanner;

public class StairsAndChild {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        for (int i = 2; i < array.length; i++) {
            array[i] += Math.min(array[i - 1], array[i - 2]);
        }
        System.out.println(array[n - 1]);
    }
}
