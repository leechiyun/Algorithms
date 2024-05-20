import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N;
    static Set<Integer> results;
    static boolean[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        results = new HashSet<>();
        memo = new boolean[1001][21];
        dfs(0, 0);
        System.out.println(results.size());
    }

    static void dfs(int sum, int cnt) {
        if (memo[sum][cnt]) {
            return;
        }
        memo[sum][cnt] = true;

        if (cnt == N) {
            results.add(sum);
            return;
        }

        // 1
        dfs(sum + 1, cnt + 1);

        // 5
        dfs(sum + 5, cnt + 1);

        // 10
        dfs(sum + 10, cnt + 1);

        // 50
        dfs(sum + 50, cnt + 1);
    }
}