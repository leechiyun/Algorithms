import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        Pos pos;
        int cnt;    // 설치한 거울의 갯수
        int dir;    // 0: 가로, 1: 세로

        public Node(Pos pos, int cnt, int dir) {
            this.pos = pos;
            this.cnt = cnt;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "pos=" + pos +
                    ", cnt=" + cnt +
                    ", dir=" + dir +
                    '}';
        }
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y){
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

    static int N;
    static char map[][];
    static int dx[][] = {{0, 0}, {1, -1}};  // 가로, 세로
    static int dy[][] = {{1, -1}, {0, 0}};  // 가로, 세로

    // 1. 거울 방향은 상관없다. ( 가로 -> 세로, 세로 -> 가로) => 어디든 갈 수 있다.
    // 2. 거울을 만났을 때 설치하거나, 설치하지 않거나
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        int mirrorCnt = 0;
        Pos startPos = null;
        Pos endPos = null;
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = input.charAt(j);

                // 거울
                if(c == '!'){
                    mirrorCnt++;
                }

                if(c == '#') {
                    if(startPos == null) {
                        startPos = new Pos(i, j);
                    } else {
                        endPos = new Pos(i, j);
                    }
                }

                map[i][j] = c;
            }
        }

        // 거울의 갯수로 파악
        boolean visited[][][][] = new boolean[mirrorCnt + 1][2][N][N];
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.cnt, b.cnt);
        });
        queue.offer(new Node(startPos, 0, 0));
        queue.offer(new Node(startPos, 0, 1));
        visited[0][0][startPos.x][startPos.y] = true;
        visited[0][1][startPos.x][startPos.y] = true;

        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if(curNode.pos.x == endPos.x && curNode.pos.y == endPos.y) {
                System.out.println(curNode.cnt);
                return;
            }

            for(int d = 0; d < 2; d++) {
                int nextX = curNode.pos.x + dx[curNode.dir][d];
                int nextY = curNode.pos.y + dy[curNode.dir][d];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N
                        || map[nextX][nextY] == '*' || visited[curNode.cnt][curNode.dir][nextX][nextY]) {
                    continue;
                }
                
                // 거울일 경우
                if(map[nextX][nextY] == '!' && curNode.cnt < mirrorCnt) {
                    // 거울 설치
                    queue.offer(new Node(new Pos(nextX, nextY), curNode.cnt + 1, (curNode.dir + 1) % 2));
                    visited[curNode.cnt + 1][(curNode.dir + 1) % 2][nextX][nextY] = true;
                }

                queue.offer(new Node(new Pos(nextX, nextY), curNode.cnt, curNode.dir));
                visited[curNode.cnt][curNode.dir][nextX][nextY] = true;
            }
        }

        System.out.println(result);
    }
}