import java.util.Scanner;

public class DangerExplosion {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n + 2];
            arr[0] = 0;
            arr[1] = 2;
            arr[2] = 3;
            for (int i = 3; i <= n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            System.out.println(arr[n]);
    }
}
