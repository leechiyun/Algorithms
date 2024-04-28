import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Brick {
        int num;
        int area, height, weight;

        public Brick(int num, int area, int height, int weight) {
            this.num = num;
            this.area = area;
            this.height = height;
            this.weight = weight;
        }
    }

    static int N;
    static List<Brick> bricks;
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        bricks = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int area = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            bricks.add(new Brick(i, area, height, weight));
        }

        // dp로 해당 번호가 가장 아래에 쌓고 쌓일 수 있는 높이 계산
        dp = new int[N];
        Collections.sort(bricks, (a, b) -> {
            return Integer.compare(a.area, b.area);
        });

        int maxHeigh = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            dp[i] = bricks.get(i).height;
            for(int j = 0; j < i; j++) {
                if(bricks.get(i).weight > bricks.get(j).weight) {
                    dp[i] = Math.max(dp[i], dp[j] + bricks.get(i).height);
                }
            }

            maxHeigh = Math.max(maxHeigh, dp[i]);
        }

        List<Integer> results = new ArrayList<>();
        for(int i = N - 1; i >= 0; i--) {
            if(maxHeigh == dp[i]) {
                maxHeigh -= bricks.get(i).height;
                results.add(bricks.get(i).num);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(results.size() + "\n");
        for (int i = results.size()-1; i >= 0; i--) {
            sb.append(results.get(i) + "\n");
        }

        System.out.println(sb);
    }
}