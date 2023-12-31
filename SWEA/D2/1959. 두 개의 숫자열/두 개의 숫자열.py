import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int arrN[] = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arrN[i] = Integer.parseInt(st.nextToken());
            }

            int arrM[] = new int[M];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                arrM[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> results = new ArrayList<>();
            if(N > M) {
                for (int i = 0; i <= N - M; i++) {
                    int sum = 0;
                    for (int j = 0; j < M; j++) {
                        sum += arrN[i + j] * arrM[j];
                    }
                    results.add(sum);
                }

            } else {
                for (int i = 0; i <= M - N; i++) {
                    int sum = 0;
                    for (int j = 0; j < N; j++) {
                        sum += arrM[i + j] * arrN[j];
                    }
                    results.add(sum);
                }
            }

            System.out.println("#" + tc + " " + Collections.max(results));
        }

    }

}
