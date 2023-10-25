import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static Long dp[][];
    static final Long DIV_VALUE = 1000000000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Long[N + 1][10];

        dp[1][0] = 0L;
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1L;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if(j == 0){
                    dp[i][j] = dp[i-1][1] % DIV_VALUE;
                }
                if(j == 9){
                    dp[i][j] = dp[i-1][8] % DIV_VALUE;
                }
                if(j > 0 && j < 9){
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % DIV_VALUE;
                }
            }
        }

        Long result = 0L;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }
        System.out.println(result % DIV_VALUE);
    }
}

