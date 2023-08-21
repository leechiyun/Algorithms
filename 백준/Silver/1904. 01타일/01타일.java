import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 00 or 1 타일
        /*
         * N = 2 => 00, 11
         * N = 3 => 001, 100, 111
         * N = 4 => 0000, 0011, 1001, 1100, 1111 (dp[2] + do[3])
         * N = 5 => (00001, 00100, 00111), (10000, ... )(dp[3] + do[4] )
         * N = 6 => (00...., ...), (11
         **/
        Long dp[] = new Long[N + 1];

        dp[1] = 1L;
        if(2 <= N){
            dp[2] = 2L;
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        System.out.println(dp[N]);
    }
}