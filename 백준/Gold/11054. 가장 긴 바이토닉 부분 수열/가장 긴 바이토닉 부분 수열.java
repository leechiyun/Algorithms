import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int arr[];

    static int lDp[], rDp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lDp = new int[N];
        rDp = new int[N];
        for (int i = 0; i < N; i++) {
            lDp[i] = 1;

            int maxL = 0;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    maxL = Math.max(maxL, lDp[j]);
                }
            }

            lDp[i] += maxL;
        }

        for (int i = N - 1; i >= 0; i--) {
            rDp[i] = 1;

            int maxR = 0;
            for (int j = N - 1; j >= i; j--) {
                if(arr[j] < arr[i]) {
                    maxR = Math.max(maxR, rDp[j]);
                }
            }

            rDp[i] += maxR;
        }

        PriorityQueue<Integer> sums = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b, a);
        });
        for (int i = 0; i < N; i++) {
            sums.offer(lDp[i] + rDp[i] - 1);
        }

        System.out.println(sums.poll());
    }
}