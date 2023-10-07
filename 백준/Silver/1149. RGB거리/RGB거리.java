import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static final int R = 0;
    static final int G = 1;
    static final int B = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dp[][] = new int[N][3];
        int map[][] = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 초기값 설정
        dp[0][R] = map[0][R];
        dp[0][G] = map[0][G];
        dp[0][B] = map[0][B];

        // dp를 통해 서로 비교
        for (int i = 1; i < N; i++) {
            dp[i][R] = map[i][R] + Math.min(dp[i-1][G], dp[i-1][B]);
            dp[i][G] = map[i][G] + Math.min(dp[i-1][R], dp[i-1][B]);
            dp[i][B] = map[i][B] + Math.min(dp[i-1][R], dp[i-1][G]);
        }

        System.out.println(Math.min(dp[N-1][R], Math.min(dp[N-1][G], dp[N-1][B])));
    }
}

