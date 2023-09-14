import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int map[][];
    static boolean visited[][];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // V: 정점의 갯수, E: 간선의 갯수
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new int[N][M];

        Deque<Node> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 1) {
                    queue.offer(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        // 방향 왼, 오, 위, 아래
        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};


        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nextX = cur.x + dx[k];
                int nextY = cur.y + dy[k];

                // 방향 범위 넣는지, 다음에 갈 곳을 이미 갔는지 확인
                if (nextX < N && nextX >= 0 && nextY < M && nextY >= 0 && !visited[nextX][nextY] && map[nextX][nextY] == 0) {
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] += map[cur.x][cur.y] + 1;
                    queue.offer(new Node(nextX, nextY));
                }
            }
        }

        int result = Integer.MIN_VALUE;
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (result < map[i][j]) {
                    result = map[i][j];
                }
                if (map[i][j] == 0) {
                    flag = false;
                }
            }
        }
        System.out.println(flag ? result - 1 : -1);
    }
}

