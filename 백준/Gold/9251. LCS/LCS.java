import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String origin = "";
    static String comp = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        origin = br.readLine();
        comp = br.readLine();

        int[][] dp = new int[origin.length() + 1][comp.length() + 1];

        for(int i = 1; i <= origin.length(); i++) {
            for(int j = 1; j <= comp.length(); j++) {

                // (i-1)과 (j-1) 번째 문자가 서로 같다면
                if(origin.charAt(i - 1) == comp.charAt(j - 1)) {
                    // 대각선 위 (i-1, j-1)의 dp에 +1 한 값으로 갱신
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                // 같지 않다면 이전 열(i-1)과 이전 행(j-1)의 값 중 큰 것으로 갱신
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[origin.length()][comp.length()]);
    }
}