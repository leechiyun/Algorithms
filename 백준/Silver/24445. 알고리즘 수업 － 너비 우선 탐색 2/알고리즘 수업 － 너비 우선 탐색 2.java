import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static List<Integer> map[];
    static boolean visitedDFS[], visitedBFS[];
    static int N,M,V;
    static StringBuilder sbDFS = new StringBuilder();
    static StringBuilder sbBFS = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // map 초기화
        visitedDFS = new boolean[N+1];
        visitedBFS = new boolean[N+1];
        map = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 연결 리스트
            map[a].add(b);
            map[b].add(a);
        }

        // 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(map[i], (a, b) -> b - a);
        }

        // BFS 구현
        int count = 1;
        int result[] = new int[N + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(V);
        visitedBFS[V] = true;
        result[V] = count;
        while (!queue.isEmpty()){
            int pos = queue.poll();

            for (int node: map[pos]) {
                if(!visitedBFS[node]){
                    queue.offer(node);
                    count++;
                    visitedBFS[node] = true;
                    result[node] = count;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

    // DFS 구현
    private static void dfs(int start) {
        visitedDFS[start] = true;
        sbDFS.append(start).append(" ");

        for(int next: map[start]){
            if(!visitedDFS[next]){
                dfs(next);
            }
        }
    }
}

