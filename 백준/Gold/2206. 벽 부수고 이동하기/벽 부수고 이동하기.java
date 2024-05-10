import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x, y;
        int count;
        int breakCnt;

        public Node(int x, int y, int count, int breakCnt) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.breakCnt = breakCnt;
        }
    }

    static int N, M;
    static int map[][];

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.count, b.count);
        });
        Node startNode = new Node(0, 0, 1, 0);
        pq.offer(startNode);

        // 하나 부시고 갈 수 있음
        boolean visited[][][] = new boolean[2][N][M];
        visited[startNode.breakCnt][startNode.x][startNode.y] = true;

        while (!pq.isEmpty()){
            Node curNode = pq.poll();

            if(curNode.x == N - 1 && curNode.y == M - 1){
                System.out.println(curNode.count);
                return;
            }

            for (int d = 0; d < dx.length; d++) {
                int nextX = curNode.x + dx[d];
                int nextY = curNode.y + dy[d];

                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M
                    && !visited[curNode.breakCnt][nextX][nextY]) {
                    // 벽을 한 번도 부순적 없다면
                    if(map[nextX][nextY] == 1 && curNode.breakCnt == 0) {
                        // 벽 부수고 이동하기
                        pq.offer(new Node(nextX, nextY, curNode.count + 1, curNode.breakCnt + 1));
                        visited[curNode.breakCnt + 1][nextX][nextY] = true;
                    }

                    if(map[nextX][nextY] == 0) {
                        pq.offer(new Node(nextX, nextY, curNode.count + 1, curNode.breakCnt));
                        visited[curNode.breakCnt][nextX][nextY] = true;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}