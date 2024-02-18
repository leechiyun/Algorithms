import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        // 4분할로 나눠서 압축해준다.
        quardTree(0, 0, N);

        System.out.println(sb);

    }
    // 큰 범위로 압축을 진행해간다.
    static void quardTree(int x, int y, int size) {
        // x, y 범위에서 size만큼 압축 가능한지 확인
        if(isCompression(x, y, size)) {
            sb.append(map[x][y]);
            return;
        }

        sb.append("(");
        // 왼쪽 위
        quardTree(x, y, size / 2);
        // 오른쪽 위
        quardTree(x, y + size / 2, size / 2);
        // 왼쪽 아래
        quardTree(x + size / 2, y, size / 2);
        // 오른쪽 아래
        quardTree(x + size / 2, y + size / 2, size / 2);
        sb.append(")");
    }

    private static boolean isCompression(int x, int y, int size) {
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(map[x][y] != map[i][j])
                    return false;
            }
        }
        return true;
    }
}