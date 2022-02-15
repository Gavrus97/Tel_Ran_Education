import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[][] dp = new int[n + 1][];
        dp[0] = new int[1];
        dp[0][0] = 1;
        if(n != 0)
            System.out.println(1);

        for (int i = 1; i < n; i++) {
            dp[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                dp[i][j] = 0;
                if(j!=i)
                    dp[i][j] += dp[i -1][j];
                if(j != 0)
                    dp[i][j] += dp[i - 1][j - 1];
                System.out.print(dp[i][j] + " ");
            }
        }
        scan.close();
    }

}
