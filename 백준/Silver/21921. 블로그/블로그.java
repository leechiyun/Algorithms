import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 슬라이딩 윈도우
        int maxVisitors = 0;
        int maxCount = 0;
        int start = 0;
        int end = X - 1;
        int total = 0;

        for (int i = start; i <= end; i++) {
            total += arr[i];
        }

        maxVisitors = total;
        maxCount = 1;

        while (end < N - 1) {
            total -= arr[start++];
            total += arr[++end];

            if (total > maxVisitors) {
                maxVisitors = total;
                maxCount = 1;
            } else if (total == maxVisitors) {
                maxCount++;
            }
        }

        if (maxVisitors == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisitors);
            System.out.println(maxCount);
        }
    }
}