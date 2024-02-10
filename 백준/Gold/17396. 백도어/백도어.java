import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static List<Node>[] graph;
    static boolean looks[];
    static boolean visited[];

    // 다익스트라 배열
    static Long[] dist;

    static class Node {
        int v;
        Long data;

        public Node(int v, Long data) {
            this.v = v;
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new List[N];
        looks = new boolean[N];
        dist = new Long[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i< N; i++){
            graph[i] = new ArrayList<>();
            dist[i] = Long.MAX_VALUE;

            if(Integer.parseInt(st.nextToken()) == 1){
                looks[i] = true;
            }
        }
        // 그래프 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Long n = Long.parseLong(st.nextToken());

            graph[x].add(new Node(y, n));
            graph[y].add(new Node(x, n));
        }

        // 다익스트라 구현
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> Long.compare(a.data, b.data) );
        queue.offer(new Node(0, 0L));
        dist[0] = 0L;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if(visited[curNode.v])
                continue;

            visited[curNode.v] = true;

            // 다음 노드 탐색
            for (Node nextNode: graph[curNode.v]) {
                if(nextNode.v < N-1 && !looks[nextNode.v] && nextNode.data + dist[curNode.v] < dist[nextNode.v]) {
                    dist[nextNode.v] = nextNode.data + dist[curNode.v];
                    queue.offer(new Node(nextNode.v, dist[nextNode.v]));
                } else if (nextNode.v == N-1 && nextNode.data + dist[curNode.v] < dist[nextNode.v]) {
                    dist[nextNode.v] = nextNode.data + dist[curNode.v];
                    queue.offer(new Node(nextNode.v, dist[nextNode.v]));
                }
            }
        }

        System.out.println(dist[N - 1] == Long.MAX_VALUE?-1:dist[N-1]);
    }
}