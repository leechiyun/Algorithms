import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int nextNode, count;

        public Node(int nextNode, int count) {
            this.nextNode = nextNode;
            this.count = count;
        }
    }

    static List<Integer> list[];
    static boolean visited[];
    static int dist[];
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // V: 정점의 갯수, E: 간선의 갯수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        // 그래프 연결 리스트
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        // 인접리스트 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        visited[start] = true;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        int result[] = new int[N + 1];
        int count = 0;
        result[start] = ++count;
        // bfs
        while (!queue.isEmpty()) {
            int curNode = queue.poll();

            for (int node : list[curNode]) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.offer(node);
                    result[node] = ++count;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]);
            if (i < N) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
