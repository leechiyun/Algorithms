import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer> scvs;
    static int attack[] = {9, 3, 1};
    static Set<List<Integer>> results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        scvs = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scvs.add(Integer.parseInt(st.nextToken()));
        }

        // 초기 결과 리스트 추가
        results = new HashSet<>();
        results.add(new ArrayList<>(scvs));

        int time = 0;
        while (true) {
            time++;

            Set<List<Integer>> newResults = new HashSet<>();

            // 뮤탈 공격
            for (List<Integer> result : results) {
                // 순서를 섞는다.
                permutation(0, result, new int[result.size()], new boolean[result.size()], newResults);
            }

            results = newResults;

            // 모든 SCV가 파괴되었는지 확인
            for (List<Integer> result : results) {
                if (result.isEmpty()) {
                    System.out.println(time);
                    return;
                }
            }

        }
    }

    // 순열을 이용하여 공격 순서를 구한다.
    static void permutation(int cnt, List<Integer> result, int[] choosed, boolean[] visited, Set<List<Integer>> newResults) {
        if (cnt == result.size()) {
            List<Integer> newList = new ArrayList<>();
            for (int i = 0; i < choosed.length; i++) {
                int n = result.get(choosed[i]) - attack[i];
                if (n > 0) {
                    newList.add(n);
                }
            }
            newResults.add(newList);
            return;
        }

        for (int i = 0; i < result.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                choosed[cnt] = i;
                permutation(cnt + 1, result, choosed, visited, newResults);
                visited[i] = false;
            }
        }
    }
}