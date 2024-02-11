import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class UnionFind {
        private int[] parent;

        public UnionFind(int size) {
            parent = new int[size];

            // 모든 노드의 초기 부모는 자기 자신
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        // 부모노드 찾기
        public int find(int x) {
            // 부모노드 찾음
            if(parent[x] == x){
                return x;
            }

            return parent[x] = find(parent[x]);
        }

        // 합치기
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX < rootY) {
                parent[rootY] = rootX;
            } else{
                parent[rootX] = rootY;
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        UnionFind uf = new UnionFind(N);

        int result = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 원소 x, y의 부모가 같으면 사이클 형성되어 있다
            if(uf.find(x) == uf.find(y)) {
                result = i + 1;
                break;
            } else{
                uf.union(x, y);
            }
        }
        System.out.println(result);
    }
}