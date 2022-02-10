import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //System.out.println(getFibonacci(20));
        System.out.println(findNumber(20));

    }

    public static int findNumber(int n) {


        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 1) {
                dp[i] = dp[i / 2] - dp[i / 2 - 1];
            } else {
                dp[i] = dp[i / 2] + dp[i / 2 - 1];
            }
        }
        return dp[n];
    }

    public static long getFibonacci(int n) {
        List<Integer> fibonacci = new ArrayList<>();
        int first = 1;
        int second = 1;
        int fib;

        fibonacci.add(1);
        fibonacci.add(1);

        for (int i = 2; i <= n; i++) {
            fib = (first + second) % 10;
            fibonacci.add(fib);
            first = second;
            second = fib;
        }
        return fibonacci.get(n);

    }

    public static long getFibonacciSolution() {


        int n = 4;


        int[] dp = new int[n + 1];
        dp[0] = 0;

        dp[1] = 2;
        dp[2] = 4;
        dp[3] = 7;
        for (int i = 4; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return (dp[n]);
    }
}
