import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dp = new int[41];
    static int count = 0;
    static int dpCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        fib(N);
        dpFib(N);

        System.out.println(count + " " +dpCount);
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            count++;
            return 1;
        } else return (fib(n - 1) + fib(n - 2));
    }
    public static int dpFib(int n) {
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dpCount++;
        }

        return dp[n];
    }
}