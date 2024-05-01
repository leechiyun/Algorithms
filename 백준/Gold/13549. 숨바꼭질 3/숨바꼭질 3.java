import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int node;
        int data;

        public Node(int node, int data) {
            this.node = node;
            this.data = data;
        }
    }

    static int N, K;
    static List<Node> graph[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N >= K) {
            System.out.println(N - K);
            return;
        }

        graph = new List[K * 2 + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < graph.length; i++) {
            if(i + 1 < graph.length) {
                graph[i].add(new Node(i + 1, 1));
            }

            if(i * 2 < graph.length) {
                graph[i].add(new Node(i * 2, 0));
            }

            if(i != 0) {
                graph[i].add(new Node(i -1, 1));
            }
        }

        // 다익스트라
        int dist[] = new int[K * 2 + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        boolean visited[] = new boolean[K * 2 + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.data, b.data);
        });
        dist[N] = 0;
        pq.offer(new Node(N, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.node])
                continue;
            visited[cur.node] = true;

            for(Node next: graph[cur.node]) {
                if(dist[next.node] > cur.data + next.data) {
                    dist[next.node] = cur.data + next.data;
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }

        System.out.println(dist[K]);
    }
}