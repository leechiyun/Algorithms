import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Node {
        int x, y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int map[][];
    static boolean visited[][];
    static int dist[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // V: 정점의 갯수, E: 간선의 갯수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String strInput = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(strInput.charAt(j));
            }
        }

        // 방향 왼, 오, 위, 아래
        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            
            // 목적지에 도착하면 지금까지 총 거리 저장
            if(cur.x == N-1 && cur.y == M-1){
                result.add(cur.count);
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                // 방향 범위 넣는지, 다음에 갈 곳을 이미 갔는지 확인
                if(nextX < N && nextX >= 0 && nextY < M && nextY >= 0 && !visited[nextX][nextY] && map[nextX][nextY] == 1){
                    visited[nextX][nextY] = true;
                    queue.offer(new Node(nextX, nextY, cur.count + 1));
                }
            }
        }
        System.out.println(Collections.min(result));
    }
}

