import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        dp[0] = 0;
        dp[1] = list.get(0);
        if(N >= 2){
            dp[2] = dp[1] + list.get(1);
        }
        for (int i = 3; i <= N; i++) {
            // 마지막 값을 항상 가져야 하는 것은 아님
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2], dp[i-3] + list.get(i-2)) + list.get(i-1));
        }
        System.out.println(dp[N]);
    }
}