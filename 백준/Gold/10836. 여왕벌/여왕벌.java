import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int map[][];
    static List<Node> nodes;
    static int nums[] = {0, 1, 2};

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = 1;
            }
        }

        nodes = new ArrayList<>();
        for (int i = N-1; i >= 0; i--) {
            nodes.add(new Node(i, 0));
        }
        for (int j = 1; j < N; j++) {
            nodes.add(new Node(0, j));
        }

        int[] prefixSum = new int[N + N - 1];
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int i = a; i < a + b; i++) {
                prefixSum[i] += 1;
            }
            for (int i = a + b; i < 2*N - 1; i++) {
                prefixSum[i] += 2;
            }
        }
        for (int i = 0; i < prefixSum.length; i++) {
            Node cur = nodes.get(i);

            map[cur.x][cur.y] += prefixSum[i];
        }

        // 돌아가며 왼쪽, 왼쪽위, 위를 비교하고 큰 값저장
        int dx[] = {0, -1, -1};
        int dy[] = {-1, -1, 0};
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                for (int d = 0; d < dx.length; d++) {
                    int nextX = i + dx[d];
                    int nextY = j + dy[d];

                    if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                        map[i][j] = Math.max(map[i][j], map[nextX][nextY]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}