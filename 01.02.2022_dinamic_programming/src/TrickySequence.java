import java.util.Scanner;

public class TrickySequence {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0)
                dp[i] = dp[i / 2] + 1;
            else
                dp[i] = dp[i / 2 + 1] + 1 + dp[i / 2];
        }
        System.out.println(dp[n]);
    }
}
