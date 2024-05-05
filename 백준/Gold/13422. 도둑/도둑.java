import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static long arr[];

    // 1. 평범하게 N에서 M만큼 값을 구하면 시간복잡도 O(N*M) => 시간 초과
    // 2. 누적합으로 왼쪽값을 빼고 오른쪽값을 더하면서 구하면 O(N + M)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new long[N + M - 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            for(int i = 0; i < M - 1; i++){
                arr[N + i] = arr[i];
            }

            // 누적합 또한 시작점이 0 ~ N-1 이기에 N
            long sumArr[] = new long[N];
            long sum = 0;

            int result = 0;

            // 초기 누적합 구하기
            for (int i = 0; i < M; i++) {
                sum += arr[i];
            }
            sumArr[0] = sum;

            if(sumArr[0] < K){
                result++;
            }

            // !! edge case : N == M이면 하나만 확인하면됨
            if(N == M) {
                sb.append(result + "\n");
                continue;
            }

            int left = 0;
            int right = M - 1;
            for (int i = 1; i < N; i++) {
                sum -= arr[left++];
                sum += arr[++right];

                sumArr[i] = sum;

                if(sumArr[i] < K)
                    result++;
            }

            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}