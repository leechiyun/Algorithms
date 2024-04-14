import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (p1 <= p2 && p2 < N) {
            if(sum < S) {
                sum += arr[p2++];
            } else {
                result = Math.min(result, p2 - p1);
                sum -= arr[p1++];
            }
        }

        while (p1 < N && sum >= S) {
            result = Math.min(result, p2 - p1);
            sum -= arr[p1++];
        }

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }
}