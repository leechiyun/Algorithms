import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 90도 회전
            int[][] mapA = turnMap(map);
            // 180도 회전
            int[][] mapB = turnMap(mapA);
            // 270도 회전
            int[][] mapC = turnMap(mapB);

            // 출력
            System.out.println("#" + tc);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(mapA[i][j]);
                }

                sb.append(" ");
                for (int j = 0; j < N; j++) {
                    sb.append(mapB[i][j]);
                }

                sb.append(" ");
                for (int j = 0; j < N; j++) {
                    sb.append(mapC[i][j]);
                }
                if(i != N - 1) {
                    sb.append("\n");
                }
            }
            System.out.println(sb);
        }

    }

    // 90도 회전
    private static int[][] turnMap(int[][] map) {
        int N = map.length;
        int[][] newMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newMap[i][j] = map[N - j - 1][i];
            }
        }
        return newMap;
    }
}
