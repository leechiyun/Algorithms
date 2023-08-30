import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static Long dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int max = 0;
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > max)   max = num;
            input.add(num);
        }

        // dp 초기값 설정
        if(max <= 3){
            max = 3;
        }
        dp = new Long[max+1];
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        for (int value:input) {
            System.out.println(dp[value]);
        }
    }
}