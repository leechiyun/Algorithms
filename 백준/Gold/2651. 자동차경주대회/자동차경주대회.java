import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int 최대거리;
    static int N;
    static int 거리배열[];
    static int 정비시간배열[];
    static int 도착거리;

    static List<Integer> result;
    static int minTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        최대거리 = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        거리배열 = new int[N + 2];
        정비시간배열 = new int[N + 2];

        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N + 1; i++) {
            sum += Integer.parseInt(st.nextToken());
            거리배열[i] = sum;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int time = Integer.parseInt(st.nextToken());
            정비시간배열[i] = time;
        }

        result = new ArrayList<>();
        int arr[] = new int[N + 2];
        for(int i = 1; i < 거리배열.length; i++) {
            long minTime = Long.MAX_VALUE;

            for (int j = i - 1; j >= 0; j--) {
                // 해당 지점을 이을 수 없음
                if(거리배열[i] - 거리배열[j] > 최대거리) {
                    break;
                }

                // i와 j 잇기
                if(minTime > 정비시간배열[j]) {
                    arr[i] = j;
                    minTime = 정비시간배열[j];
                }
            }

            if(minTime != Long.MAX_VALUE)
                정비시간배열[i] += minTime;
        }

        // 이어진 점들 확인
        int prev = arr[N + 1];
        while(prev != 0) {
            result.add(prev);
            prev = arr[prev];
        }

        Collections.sort(result);
        System.out.println(정비시간배열[N+1]);
        System.out.println(result.size());
        for (int n : result) {
            System.out.print(n + " ");
        }
    }

    // 메모이제이션도 활용해 보았지만 불가능!
//    static int dfs(int idx, int time, int prevIdx, List<Integer> choosed) {
//        if (idx == N + 1) {
//            if (도착거리 - 거리배열[prevIdx] <= 최대거리) {
//                System.out.println(prevIdx);
//                if (time < minTime) {
//                    minTime = time;
//                    result = new ArrayList<>(choosed);
//                }
//                return time;
//            }
//            return Integer.MAX_VALUE;
//        }
//
//        if (memo[idx][prevIdx] != -1) {
//            if(memo[idx][prevIdx] < time) {
//                memo[idx][prevIdx] = time;
//            }
//
//            return memo[idx][prevIdx];
//        }
//
//        int minCost = Integer.MAX_VALUE;
//
//        // 정비소 선택하지 않음
//        minCost = Math.min(minCost, dfs(idx + 1, time, prevIdx, choosed));
//
//        // 정비소 선택
//        if (거리배열[idx] - 거리배열[prevIdx] <= 최대거리) {
//            choosed.add(idx);
//            int cost = dfs(idx + 1, time + 정비시간배열[idx - 1], idx, choosed);
//            minCost = Math.min(minCost, cost);
//            choosed.remove(choosed.size() - 1);
//        }
//
//        memo[idx][prevIdx] = minCost;
//        return minCost;
//    }
}