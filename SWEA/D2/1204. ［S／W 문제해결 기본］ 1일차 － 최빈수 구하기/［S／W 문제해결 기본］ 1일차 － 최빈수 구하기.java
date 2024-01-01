import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int testCase = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 1000; i++) {
                int num = Integer.parseInt(st.nextToken());

                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            List<Integer> numbers = new ArrayList<>(map.keySet());
            Collections.sort(numbers, (a, b) -> {
                if(map.get(a) == map.get(b)) {
                    return b - a;
                }
                return map.get(b) - map.get(a);
            });

            System.out.println("#" + tc + " " + numbers.get(0));
        }
    }
}
