import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int blueCnt, whiteCnt;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        

        blueCnt = 0;
        whiteCnt = 0;
        dfs(N, 0, 0);

        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    static void dfs(int n, int x, int y) {
        if (n == 0) {
            return;
        }

        int b = 0;
        int w = 0;
        for(int i = x; i < x + n; i++) {
            for(int j = y; j < y + n; j++) {
                if(map[i][j] == 1) {
                    b++;
                }
                if(map[i][j] == 0) {
                    w++;
                }
            }
        }

        if(b == n * n) {
            blueCnt++;
            return;
        }
        if(w == n * n) {
            whiteCnt++;
            return;
        }

        // 왼쪽 위
        dfs(n / 2, x, y);
        // 오른쪽 위
        dfs(n / 2, x, y + n / 2);
        // 왼쪽 아래
        dfs(n / 2, x + n / 2, y);
        // 오른쪽 아래
        dfs(n / 2, x + n / 2, y + n / 2);
    }
}