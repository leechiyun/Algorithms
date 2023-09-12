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
        StringTokenizer st;

        // V: 정점의 갯수, E: 간선의 갯수
        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String strInput = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(strInput.charAt(j));
            }
        }

        // 방향 왼, 오, 위, 아래
        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};

        Deque<Node> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j]==1){
                    queue.offer(new Node(i, j));
                    visited[i][j] = true;
                    count = 1;

                    while (!queue.isEmpty()){
                        Node cur = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nextX = cur.x + dx[k];
                            int nextY = cur.y + dy[k];

                            // 방향 범위 넣는지, 다음에 갈 곳을 이미 갔는지 확인
                            if(nextX < N && nextX >= 0 && nextY < N && nextY >= 0 && !visited[nextX][nextY] && map[nextX][nextY] == 1){
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

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (int value: result) {
            sb.append(value).append("\n");
        }
        System.out.println(sb);
    }
}

