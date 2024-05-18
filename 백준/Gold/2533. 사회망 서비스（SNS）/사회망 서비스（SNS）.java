import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer> graph[];
    static int dp[][];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        // 얼리 어답터인 경우와 아닌 경우 : 2
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        visited[1] = true;
        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int node) {
        // 1: 얼리어답터
        dp[node][1] = 1;
        dp[node][0] = 0;

        for (int next: graph[node]) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(next);

                // 자식 노드가 얼리어답터가 아닌 경우, 반드시 부모노드는 얼리어답터
                dp[node][0] += dp[next][1];
                dp[node][1] += Math.min(dp[next][1], dp[next][0]);
            }
        }
    }
}