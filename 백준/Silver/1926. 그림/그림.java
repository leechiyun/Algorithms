import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static int map[][];
    public static boolean visited[][];
    public static int N, M;
    public static int dx[] = new int[] {0, -1, 0, 1};
    public static int dy[] = new int[] {-1, 0, 1, 0};

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> resultList = new ArrayList<>();

        // 시작 지점 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1 && !visited[i][j]){
                    // BFS 구현
                    Queue<Node> queue = new ArrayDeque<>();
                    queue.offer(new Node(i, j));
                    int count = 1;
                    visited[i][j] = true;

                    while (!queue.isEmpty()){
                        Node curNode = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nextX = curNode.x + dx[k];
                            int nextY = curNode.y + dy[k];

                            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && map[nextX][nextY] == 1 && !visited[nextX][nextY]){
                                visited[nextX][nextY] = true;
                                queue.offer(new Node(nextX, nextY));
                                count++;
                            }
                        }
                    }
                    resultList.add(count);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(resultList.size()).append("\n");
        if(resultList.size() == 0){
            sb.append(0);
        } else {
            sb.append(Collections.max(resultList));
        }

        System.out.println(sb);
    }
}

