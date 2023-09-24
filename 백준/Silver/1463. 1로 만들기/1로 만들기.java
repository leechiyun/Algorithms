import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 3];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                if (min > dp[i / 3]) {
                    min = dp[i / 3];
                }
            }
            if (i % 2 == 0) {
                if (min > dp[i / 2]) {
                    min = dp[i / 2];
                }
            }
            if (min > dp[i - 1]) {
                min = dp[i - 1];
            }
            
            dp[i] = 1 + min;
        }

        System.out.println(dp[N]);

    }
}

