import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H, W;
    static int map[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        // 핵심!!
        // 왼쪽 최대 높이와 오른쪽 최대 높이 보다 작을 때, 빗물은 작은 쪽의 차이만큼 고인다.
        int leftMaxHeight = 0;
        int rightMaxHeight = 0;
        // 처음과 끝은 고일 수 없다
        int result = 0;
        for (int i = 1; i < W - 1; i++) {
            leftMaxHeight = 0;
            rightMaxHeight = 0;

            // 왼쪽 최대 높이 구하기
            for (int j = 0; j < i; j++) {
                leftMaxHeight = Math.max(leftMaxHeight, map[j]);
            }

            // 오른쪽 최대 높이 구하기
            for (int j = i + 1; j < W; j++) {
                rightMaxHeight = Math.max(rightMaxHeight, map[j]);
            }

            if (map[i] < leftMaxHeight && map[i] < rightMaxHeight) {
                result += Math.min(leftMaxHeight, rightMaxHeight) - map[i];
            }
        }

        System.out.println(result);
    }
}