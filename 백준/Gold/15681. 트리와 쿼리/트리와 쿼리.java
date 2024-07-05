import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, R, Q;

    static List<Integer> tree[];
    static int memo[];      // 해당 노드의 서브트리 갯수
    static boolean visited[];

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());   // 루드 노드
        Q = Integer.parseInt(st.nextToken());

        tree = new List[N + 1];
        for (int i = 0; i <= N; i++) {
           tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N- 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        memo = new int[N + 1];
        visited = new boolean[N + 1];
        visited[R] = true;
        cnt = 1;
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(memo[n] + "\n");
        }
        System.out.println(sb);
    }

    static int dfs(int node) {
        if(memo[node] > 0) {
            return memo[node];
        }

        int total = 1;
        for(int next: tree[node]) {
            if(!visited[next]) {
                visited[next] = true;
                total += dfs(next);
            }
        }

        return memo[node] = total;
    }
}