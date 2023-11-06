import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    private static final int RED = 1;
    private static final int GREEN = 2;
    private static final int BLUE = 3;

    static int map[][];
    static int blindMap[][];
    static boolean blindVisited[][];
    static boolean visited[][];

    static int dx[] = new int[]{0, -1, 0, 1};
    static int dy[] = new int[]{-1, 0, 1, 0};

    static int N = 0;

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        blindMap = new int[N][N];
        blindVisited = new boolean[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = input.charAt(j);

                if (c == 'R') {
                    map[i][j] = RED;
                    blindMap[i][j] = RED;
                }
                if (c == 'G') {
                    map[i][j] = GREEN;
                    blindMap[i][j] = RED;
                }
                if (c == 'B') {
                    map[i][j] = BLUE;
                    blindMap[i][j] = BLUE;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(BFS(map, visited)).append(" ").append(BFS(blindMap, blindVisited));
        System.out.println(sb);
    }

    private static int BFS(int map[][], boolean visited[][]) {
        int curColor = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    curColor = map[i][j];

                    Queue<Node> queue = new ArrayDeque<>();
                    queue.offer(new Node(i, j));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        Node curNode = queue.poll();

                        for (int k = 0; k < dx.length; k++) {
                            int nextX = curNode.x + dx[k];
                            int nextY = curNode.y + dy[k];

                            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY]
                                    && map[nextX][nextY] == curColor) {
                                queue.offer(new Node(nextX, nextY));
                                visited[nextX][nextY] = true;
                            }
                        }
                    }
                    result++;
                }
            }
        }

        return result;
    }
}
