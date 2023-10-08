import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 물품의 수 : N, 버틸 수 있는 무게 : K
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 물품의 무게와 가치 저장 배열
        int items[][] = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        int dp[][] = new int[N+1][K+1];
        for (int i = 1; i <= N; i++) {
            // 첫 번째, 물품부터 시작해서 dp 채운다
            for (int j = 1; j <= K; j++) {
                // 물품을 가방에 넣을 수 있는 경우
                if(items[i][0] <= j){
                    /*
                     * dp[i-1][j-items[i][0]] : 물품의 무게를 뺀 최적값
                     * */
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i][0]] + items[i][1]);
                }
                // 물품을 가방에 넣을 수 없는 경우, 이전의 최적값을 유지
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }

        }

        System.out.println(dp[N][K]);
    }
}

