import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD = 1_000_000;
    private static final int PERIOD = 1_500_000; // 주기 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine()) % PERIOD;

        long[] dp = new long[PERIOD + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
        }

        System.out.println(dp[(int) N]);
    }
}