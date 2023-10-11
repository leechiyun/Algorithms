import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int map[][];
    static boolean visited[][];

    static class Pos{
        int x, y;
        int count = 0;

        public Pos(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int dx[] = new int[]{-2, -1, 1, 2, 2, 1, -2, -1};
    static int dy[] = new int[]{1, 2, 2, 1, -1, -2, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int I = Integer.parseInt(br.readLine());

            map = new int[I][I];
            visited = new boolean[I][I];
            List<Integer> resultList = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            // BFS 시작
            Queue<Pos> queue = new ArrayDeque<>();
            queue.offer(new Pos(startX, startY, 0));
            visited[startX][startY] = true;

            while (!queue.isEmpty()){
                Pos curPos = queue.poll();

                if(curPos.x == endX && curPos.y == endY){
                    resultList.add(curPos.count);
                }

                // 나이트의 이동 경로는 8개
                for (int j = 0; j < dx.length; j++) {
                    int nextX = curPos.x + dx[j];
                    int nextY = curPos.y + dy[j];

                    if(nextX >= 0 && nextX < I && nextY >= 0 && nextY < I && !visited[nextX][nextY]){
                        queue.offer(new Pos(nextX, nextY, curPos.count + 1));
                        visited[nextX][nextY] = true;
                    }
                }
            }

            sb.append(Collections.min(resultList)).append("\n");
        }
        System.out.println(sb);
    }
}

