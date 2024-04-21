import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int dp[];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        if(N > 2) {
            dp = new int[N + 1];
        } else {
            dp = new int[3];
        }
        dp[1] = 1;
        dp[2] = 3;

//        dfs(0);
//        System.out.println(cnt);

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[N]);
    }

//    static void dfs(int n) {
//        if(n == N) {
//            cnt++;
//            return;
//        }
//
//        // 2개와, 1개로 가능하다.
//        if(n + 1 <= N) {
//            dfs(n + 1);
//        }
//        if(n + 2 <= N) {
//            dfs(n + 2);
//        }
//    }
}