import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static boolean[][][] visited;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Map<Character, Integer> doorKey = new HashMap<>();

    static class Node {
        int x, y;
        int count;
        int keys; // 비트마스크로 키 상태 표현

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.keys = 0;
        }

        @Override
        public String toString() {
            return "Node [x=" + x + ", y=" + y + ", count=" + count + ", keys=" + keys + "]";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // doorKey
        for (char c = 'a'; c <= 'f'; c++) {
            doorKey.put(Character.toUpperCase(c), 1 << (c - 'a')); // 비트마스크로 키 상태 표현
        }

        // 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[1 << 6][N][M]; // 비트마스크 크기에 맞게 방문 배열 크기 조정

        Node startNode = null;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);
                if (c - '0' == 0) {
                    startNode = new Node(i, j, 0);
                }
                map[i][j] = c;
            }
        }

        // BFS 구현
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(startNode);
        visited[startNode.keys][startNode.x][startNode.y] = true;
        int result = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            // 도착
            if (map[curNode.x][curNode.y] == '1') {
                result = Math.min(result, curNode.count);
                System.out.println(result);
                return;
            }

            for (int d = 0; d < dx.length; d++) {
                int nextX = curNode.x + dx[d];
                int nextY = curNode.y + dy[d];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[curNode.keys][nextX][nextY]
                        && map[nextX][nextY] != '#') {
                    char c = map[nextX][nextY];
                    Node nextNode = new Node(nextX, nextY, curNode.count + 1);
                    nextNode.keys = curNode.keys;

                    // 열쇠 방인 경우
                    if (c >= 'a' && c <= 'f') {
                        nextNode.keys |= (1 << (c - 'a')); // 비트마스크로 키 상태 업데이트
                    }
                    // 문인 경우
                    else if (c >= 'A' && c <= 'F') {
                        if ((nextNode.keys & doorKey.get(c)) == 0) { // 비트마스크로 키 소유 여부 확인
                            continue;
                        }
                    }

                    visited[nextNode.keys][nextX][nextY] = true;
                    queue.offer(nextNode);
                }
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}