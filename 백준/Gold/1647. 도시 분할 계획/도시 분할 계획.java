import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static Edge edges[];

    static class Edge{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", weight=" + weight +
                    '}';
        }
    }

    static class UnionFind {
        int[] parents;

        public UnionFind(int size) {
            parents = new int[size];

            for (int i = 0; i < size; i++) {
                parents[i] = i;
            }
        }

        // find
        public int find(int x) {
            if(x == parents[x])
                return x;

            return parents[x] = find(parents[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX < rootY) {
                parents[rootY] = rootX;
            } else {
                parents[rootX] = rootY;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edges = new Edge[M];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(start, end, weight);
        }

        // 1. 정렬
        Arrays.sort(edges, (a, b) -> Integer.compare(a.weight, b.weight));

        // 2. MST 시작, Union-Find로 사이클이 되는지 확인하여 최소 간선 찾기
        UnionFind uf = new UnionFind(N + 1);

        int cnt = 0;
        int totalWeight = 0;
        for(Edge edge: edges) {
            if(cnt >= N - 2)
                break;

            // 사이클 X
            if(uf.find(edge.start) != uf.find(edge.end)) {
                uf.union(edge.start, edge.end);
                
                cnt++;      // 연결된 간선의 수
                totalWeight += edge.weight;
            }
        }

        System.out.println(totalWeight);
    }
}