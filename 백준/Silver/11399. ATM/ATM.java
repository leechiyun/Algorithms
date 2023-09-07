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
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        // 1. sort
        Collections.sort(list);

        // 2. dp 알고리즘 사용해서 해당 위치의 기다리는 수 구함
        dp = new int[N+1];
        dp[1] = list.get(0);
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + list.get(i-1);
        }

        // 3. result => 총 기다리는 시간
        int result = 0;
        for (int i = 1; i <= N; i++) {
            result += dp[i];
        }
        System.out.println(result);
    }
}