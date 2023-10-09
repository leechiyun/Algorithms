import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static boolean visited[];
    static List<Integer> list[];
    static int count = 0;
    static int result[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        result = new int[N+1];
        list = new List[N+1];
        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 양방향 간선
            list[x].add(y);
            list[y].add(x);
        }
        
        // 내림 차순
        for (int i = 1; i < N+1; i++) {
            Collections.sort(list[i], (a, b) -> b - a);
        }

        dfs(start);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int node) {
        // 해당 노드 방문함
        visited[node] = true;
        result[node] = ++count;

        for (int next: list[node]){
            if(!visited[next]){
                dfs(next);
            }
        }

    }
}

