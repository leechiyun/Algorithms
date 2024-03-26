import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // C * N = 10000
        int dp[][] = new int[N + 1][10001];

        int Ms[] = new int[N + 1];
        int Cs[] = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            Ms[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            Cs[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int memory = Ms[i];
            int cost = Cs[i];

            for (int j = 0; j <= 10000; j++) {
                if (j >= cost) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + memory);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

                if(dp[i][j] >= M) {
                    result = Math.min(result, j);
                }
            }
        }

        System.out.println(result);
    }
}