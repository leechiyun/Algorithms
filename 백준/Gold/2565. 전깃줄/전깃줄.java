import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// LCS 문제
public class Main {

    static int N;
    static int arr[][];
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new int[2];

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i][0] = x;
            arr[i][1] = y;
        }

        Arrays.sort(arr, (a, b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if(arr[j][0] < arr[i][0] && arr[j][1] < arr[i][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);
    }
}