import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N = 10;
    static Map<Integer, Integer> paperMap;
    static boolean visited[][];
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if(input == 0)
                    visited[i][j] = true;

            }
        }

        paperMap = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            paperMap.put(i, 5);
        }

        result = Integer.MAX_VALUE;
        dfs(0, 0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void dfs(int cnt, int paperCnt) {
        if (paperCnt >= result) {
            return;
        }

        if(cnt == 100) {
            result = Math.min(result, paperCnt);

            return;
        }

        int x = cnt / 10;
        int y = cnt % 10;

        // 색종이를 붙여야 하면,
        if(!visited[x][y]) {
            // 1, 2, 3, 4, 5의 색종이로 붙일 수 있는지 확인
            // 그리드 관점으로 5부터 확인한다.
            for (int c = 5; c > 0; c--) {
                if(isPossible(x, y, c) && paperMap.get(c) > 0) {
                    for (int i = x; i < x + c; i++) {
                        for (int j = y; j < y + c; j++) {
                            visited[i][j] = true;
                        }
                    }

                    paperMap.put(c, paperMap.get(c) - 1);
                    dfs(cnt + 1, paperCnt + 1);
                    paperMap.put(c, paperMap.get(c) + 1);

                    for (int i = x; i < x + c; i++) {
                        for (int j = y; j < y + c; j++) {
                            visited[i][j] = false;
                        }
                    }
                }
            }

        }else {
            dfs(cnt + 1, paperCnt);
        }
    }

    private static boolean isPossible(int x, int y, int cnt) {
        for (int i = x; i < x + cnt; i++) {
            for (int j = y; j < y + cnt; j++) {
                if(i < 0 || i >= N || j < 0 || j >= N)
                    return false;

                if(visited[i][j])
                    return false;
            }
        }

        return true;
    }
}