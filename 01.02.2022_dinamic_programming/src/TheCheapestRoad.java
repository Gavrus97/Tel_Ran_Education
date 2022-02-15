import java.util.Scanner;

public class TheCheapestRoad {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int k = scan.nextInt();
                dp[i][j] = k;
            }
        }

        int[][] array = new int[n][m];
        array[0][0] = dp[0][0];

        for (int j = 1; j < m; j++) {
            array[0][j] = array[0][j - 1] + dp[0][j];
        }

        for (int i = 1; i < n; i++) {
            array[i][0] = array[i - 1][0] + dp[i][0];

            for (int j = 1; j < m; j++) {
                if (array[i - 1][j] < array[i][j - 1])
                    array[i][j] = dp[i][j] + array[i - 1][j];
                else
                    array[i][j] = dp[i][j] + array[i][j - 1];
            }
        }


        scan.close();
        System.out.println(array[n - 1][m - 1]);
    }
}
