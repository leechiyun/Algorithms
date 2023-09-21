import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < i + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i +1; j++) {
                // 위 or 왼쪽 대각선의 값의 합, 비교해서 큰 값 저장
                // 위의 값
                int up = map[i-1][j];

                // 왼쪽 대각선의 값은 범위 밖으로 나갈 수 있음
                int leftUp = 0;
                if(j - 1 >= 0){
                    leftUp = map[i-1][j-1];
                }

                map[i][j] += Math.max(up, leftUp);
            }
        }

        System.out.println(Arrays.stream(map[N-1]).max().getAsInt());
    }
}

