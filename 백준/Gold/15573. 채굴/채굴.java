import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int minPower = Integer.MAX_VALUE;
        int maxPower = Integer.MIN_VALUE;

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                minPower = Math.min(minPower, input);
                maxPower = Math.max(maxPower, input);
                map[i][j] = input;
            }
        }

        int result = binarySearch(minPower, maxPower);
        System.out.println(result);
    }

    static int binarySearch(int low, int high) {
        int result = high;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canMine(mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    static boolean canMine(int power) {
        boolean[][] visited = new boolean[N][M];
        Queue<Node> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            if (map[i][0] <= power) {
                queue.offer(new Node(i, 0));
                visited[i][0] = true;
            }

            if (map[i][M - 1] <= power) {
                queue.offer(new Node(i, M - 1));
                visited[i][M - 1] = true;
            }
        }

        for (int i = 1; i < M - 1; i++) {
            if (map[0][i] <= power) {
                queue.offer(new Node(0, i));
                visited[0][i] = true;
            }
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            cnt++;

            if (cnt >= K) {
                return true;
            }

            for (int d = 0; d < dx.length; d++) {
                int nextX = curNode.x + dx[d];
                int nextY = curNode.y + dy[d];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || visited[nextX][nextY]) {
                    continue;
                }

                if (map[nextX][nextY] <= power) {
                    queue.offer(new Node(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }

        return false;
    }

    static boolean isAirAdjacent(int x, int y, boolean[][] visited) {
        for (int d = 0; d < dx.length; d++) {
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                return true;
            }

            if (visited[nextX][nextY]) {
                return true;
            }
        }

        return false;
    }
}