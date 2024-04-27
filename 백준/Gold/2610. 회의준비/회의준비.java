import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer> graphs[];
    static int map[];

    static class UnionFind {
        int parents[];

        public UnionFind(int size) {
            parents = new int[size];

            for(int i = 0; i < size; i++) {
                parents[i] = i;
            }
        }

        public int find(int x) {
            if(x == parents[x])
                return x;

            return parents[x] = find(parents[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX < rootY) {
                parents[rootX] = rootY;
            } else{
                parents[rootY] = rootX;
            }
        }

        public int calculate() {
            Set<Integer> set = new HashSet<>();

            for(int i = 1; i < parents.length; i++) {
                set.add(find(i));
            }

            return set.size();
        }
    }

    static class Node{
        int node;
        int cnt;

        public Node(int node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "node=" + node +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1];
        graphs = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            graphs[i] = new ArrayList<>();
        }

        UnionFind uf = new UnionFind(N + 1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graphs[x].add(y);
            graphs[y].add(x);

            if(uf.find(x) != uf.find(y)) {
                uf.union(x, y);
            }
        }

        Map<Integer, PriorityQueue<Node>> group = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            // 다른 그룹
            int root = uf.find(i);
            if(!group.containsKey(root)) {
                group.put(root, new PriorityQueue<Node>((a, b) -> {
                    return Integer.compare(a.cnt, b. cnt);
                }));
            }

            Queue<Node> queue = new ArrayDeque<>();
            queue.offer(new Node(i, 0));
            boolean visited[] = new boolean[N + 1];
            visited[i] = true;
            int cnt = 0;

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                cnt = Math.max(cur.cnt, cnt);

                for (int next : graphs[cur.node]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(new Node(next, cur.cnt + 1));
                    }
                }
            }

            group.get(uf.find(i)).add(new Node(i, cnt));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(group.keySet().size()).append("\n");
        // 문제 제대로 읽기! 오름차순 정렬 출력
        PriorityQueue<Integer> nodePQ = new PriorityQueue<>();
        for(int key: group.keySet()) {
            nodePQ.offer(group.get(key).poll().node);
        }
        while (!nodePQ.isEmpty()) {
            sb.append(nodePQ.poll()).append("\n");
        }

        System.out.println(sb);
    }
}