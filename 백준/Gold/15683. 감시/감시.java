import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int map[][];
    static List<CCTV> cctvs = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    static int direction1[][][] = {{{0, 1}}, {{1, 0}}, {{0, -1}}, {{-1, 0}}};
    static int direction2[][][] = {{{0, 1}, {0, -1}}, {{1, 0}, {-1, 0}}};
    static int direction3[][][] = {{{-1, 0}, {0, 1}}, {{0, 1}, {1, 0}}, {{1, 0}, {0, -1}}, {{0, -1}, {-1, 0}}};
    static int direction4[][][] =
            {{{-1, 0}, {0, 1}, {0, -1}}, {{-1, 0}, {0, 1}, {1, 0}},
                    {{0, 1}, {0, -1}, {1, 0}}, {{-1, 0}, {0, -1}, {1, 0}}};
    static int direction5[][][] = {{{-1, 0}, {0, 1}, {0, -1}, {1, 0}}};

    static Map<Integer, int[][][]> directionMap = new HashMap<>();

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pos [x=" + x + ", y=" + y + "]";
        }
    }

    static class CCTV {
        Pos pos;
        int number;

        public CCTV(Pos pos, int number) {
            this.pos = pos;
            this.number = number;
        }

        @Override
        public String toString() {
            return "CCTV [pos=" + pos + ", number=" + number + "]";
        }

        public int[][] checkCCTV(int map[][], int[][] direction) {
            int[][] newMap = copyMap(map);

            // CCTV로 맵 밝히기
            for(int i = 0; i < direction.length; i++) {
                int nextX = pos.x + direction[i][0];
                int nextY = pos.y + direction[i][1];

                while(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M
                        && newMap[nextX][nextY] != 6) {
                    if(newMap[nextX][nextY] == 0) {
                        newMap[nextX][nextY] = -1;
                    }

                    nextX += direction[i][0];
                    nextY += direction[i][1];
                }

            }

            return newMap;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // CCTV 번호 별 방향 Map
        directionMap.put(1, direction1);
        directionMap.put(2, direction2);
        directionMap.put(3, direction3);
        directionMap.put(4, direction4);
        directionMap.put(5, direction5);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());

                if(input >= 1 && input <= 5)
                    cctvs.add(new CCTV(new Pos(i, j), input));

                map[i][j] = input;
            }
        }

        dfs(map, 0);

        System.out.println(min);
    }

    static void dfs(int map[][], int cnt) {
        if(cnt == cctvs.size()) {
            int count = 0;
            for(int i = 0; i < map.length; i++) {
                for(int j = 0; j < map[0].length; j++) {
                    if(map[i][j] == 0) {
                        count++;
                    }
                }
            }
            if(count < min){
                min = count;
            }

            return;
        }

        int[][][] direction = directionMap.get(cctvs.get(cnt).number);
        for(int i = 0; i < direction.length; i++) {
            // 해당되는 cctv 부분 밝히기
            dfs(cctvs.get(cnt).checkCCTV(map, direction[i]), cnt + 1);	// 다음 cctv
        }
    }

    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[map.length][];

        for (int i = 0; i < map.length; i++) {
            newMap[i] = Arrays.copyOf(map[i], map[i].length);
        }

        return newMap;
    }
}