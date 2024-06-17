import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import javax.swing.JList;

public class Main {

    static class Node{
        int end;
        int num;

        public Node(int end, int num) {
            this.end = end;
            this.num = num;
        }
    }

    static class Result {
        int node;
        int min;

        public Result(int node, int min) {
            this.node = node;
            this.min = min;
        }
    }

    static int A, B, C;
    static int distA[], distB[], distC[];

    static int N;

    static List<Node> graph[];

    // A, B, C의 최단 거리 dist[]를 구하고, 각 노드를 비교한다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int E = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(y, num));
            graph[y].add(new Node(x, num));
        }


        distA = dijk(A);
        distB = dijk(B);
        distC = dijk(C);

        // A, B, C 가 아니면서 노드의 최단 거리를 비교하여 구하기
        PriorityQueue<Result> results = new PriorityQueue<>((a, b) -> {
            if(a.min == b.min) {
                return Integer.compare(a.node, b.node);
            }
            return Integer.compare(b.min, a.min);
        });

        for (int i = 1; i <= N; i++) {
            if(i == A || i == B || i == C)
                continue;

            int min = Math.min(Math.min(distA[i], distB[i]), distC[i]);
            results.offer(new Result(i, min));
        }

        Result result = results.poll();
        System.out.println(result.node);
    }

    static int[] dijk(int start) {
        int dist[] = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.num, b.num);
        });
        pq.offer(new Node(start, 0));
        boolean visited[] = new boolean[N + 1];
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.end]) continue;
            visited[cur.end] = true;

            for (Node next: graph[cur.end]) {
                if(dist[next.end] > dist[cur.end] + next.num) {
                    dist[next.end] =  dist[cur.end] + next.num;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }

        return dist;
    }
}