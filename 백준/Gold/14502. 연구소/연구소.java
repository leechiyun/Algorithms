import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static int N, M;
    // 위, 아래, 왼쪽, 오른쪽
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] map;
    public static int[][] virusMap;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // map 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // dfs로 벽 세우기
        dfs(0);

        System.out.println(max);
    }

    private static void dfs(int wall) {
        if(wall == 3){
            // 바이러스 퍼뜨리기 <- bfs 구현
            Queue<int[]> queue = new LinkedList<>();
            virusMap = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    virusMap[i][j] = map[i][j];

                    // 바이러스가 있는 위치 queue에 넣기
                    if(virusMap[i][j] == 2){
                        queue.offer(new int[]{i, j});
                    }
                }
            }

            while(!queue.isEmpty()){
                int pos[] = queue.poll();
                int x = pos[0];
                int y = pos[1];

                for (int i = 0; i < 4; i++) {
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];

                    if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && virusMap[nextX][nextY] == 0){
                        virusMap[nextX][nextY] = 2;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }

            // 모든 바이러스 감염 후 안전 위치 찾기
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(virusMap[i][j] == 0){
                        count++;
                    }
                }
            }

            max = Math.max(count, max);

            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
}

