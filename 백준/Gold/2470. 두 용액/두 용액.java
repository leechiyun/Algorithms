import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        int l = 0;
        int r = N - 1;

        int rL = l;
        int rR = r;
        long sum = 0;
        while (l < r) {
            sum = arr[r] + arr[l];

            if(min > Math.abs(sum)) {
                min = Math.abs(sum);

                rL = l;
                rR = r;
            }

            if(sum == 0) {
                break;
            }
            else if(sum > 0) {
                r--;
            } else if (sum < 0) {
                l++;
            }
        }

        System.out.println(arr[rL] + " " + arr[rR]);
    }
}