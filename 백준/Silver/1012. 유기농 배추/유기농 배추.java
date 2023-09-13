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

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb =new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // V: 정점의 갯수, E: 간선의 갯수
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            visited = new boolean[N][M];
            map = new int[N][M];
            for (int i = 0; i < K; i++) {
                String strInput[] = br.readLine().split(" ");
                map[Integer.parseInt(strInput[0])][Integer.parseInt(strInput[1])] = 1;
            }

            // 방향 왼, 오, 위, 아래
            int dx[] = {0, 0, -1, 1};
            int dy[] = {-1, 1, 0, 0};

            Deque<Node> queue = new ArrayDeque<>();
            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        queue.offer(new Node(i, j));
                        visited[i][j] = true;
                        count = 1;

                        while (!queue.isEmpty()) {
                            Node cur = queue.poll();

                            for (int k = 0; k < 4; k++) {
                                int nextX = cur.x + dx[k];
                                int nextY = cur.y + dy[k];

                                // 방향 범위 넣는지, 다음에 갈 곳을 이미 갔는지 확인
                                if (nextX < N && nextX >= 0 && nextY < M && nextY >= 0 && !visited[nextX][nextY] && map[nextX][nextY] == 1) {
                                    visited[nextX][nextY] = true;
                                    queue.offer(new Node(nextX, nextY));
                                    count++;
                                }
                            }
                        }
                        result.add(count);
                    }
                }
            }
            sb.append(result.size()).append("\n");
        }

        System.out.println(sb);
    }
}

