import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    private final static int STUDENT_COUNT = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= tc; i++) {
            int testCase = Integer.parseInt(br.readLine());
            Map<Long, Long> map = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Long max = Long.MIN_VALUE;
            for (int j = 0; j < STUDENT_COUNT; j++) {
                Long num = Long.parseLong(st.nextToken());

                map.put(num, map.getOrDefault(num, 0L) + 1);
                if(max < map.get(num)){
                    max = map.get(num);
                }
            }

            List<Long> resultList = new ArrayList<>();
            for(Long key: map.keySet()) {
                if(map.get(key) == max) {
                    resultList.add(key);
                }
            }

            sb.append("#").append(i).append(" ").append(Collections.max(resultList)).append("\n");
        }
        System.out.println(sb);
    }
}
