import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int arr[];
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        result = 1;
        dfs(1, arr[N - 1] - arr[0]);
        System.out.println(result);
    }

    static void dfs(int left, int right) {
        if (left > right) {
            return;
        }
        int mid = (left + right) / 2;
        if (canInstall(mid)) {
            result = Math.max(result, mid);
            dfs(mid + 1, right);
        } else {
            dfs(left, mid - 1);
        }
    }

    static boolean canInstall(int distance) {
        int count = 1;
        int last = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] - last >= distance) {
                count++;
                last = arr[i];
            }
        }
        return count >= C;
    }
}