import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int node;
        char color;

        public Node(int node, char color) {
            this.node = node;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "node=" + node +
                    ", color=" + color +
                    '}';
        }
    }

    static int N, M, K;
    static char[] cards;
    static List<Node> graph[];
    static int dp[][];

    // 1. DFS or BFS 로 모든 정점을 N만큼 돌고 최대값을 계산하면 => O(M^N) 시간초과
    // 2. DP를 사용해 미리 최대값을 구하고, 갈 수 없는 곳은 가지치기 (?)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        cards = new char[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = st.nextToken().charAt(0);
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new List[M + 1];
        for (int i = 0; i <= M; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char color = st.nextToken().charAt(0);

            graph[x].add(new Node(y, color));
            graph[y].add(new Node(x, color));
        }

        dp = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0, 1));
    }

    static int dfs(int cnt, int node) {
        if (cnt == N) {
            return 0;
        }

        // dp에 값이 이미 있으면
        if(dp[cnt][node] != -1)
            return dp[cnt][node];

        int max = 0;
        for(Node next: graph[node]) {
            max = Math.max(max, dfs(cnt + 1, next.node) + (next.color == cards[cnt] ? 10 : 0));
        }

        return dp[cnt][node] = max;
    }
}