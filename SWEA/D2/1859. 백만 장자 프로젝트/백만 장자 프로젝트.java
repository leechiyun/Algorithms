import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= tc; i++) {
            int N = Integer.parseInt(br.readLine());
            List<Long> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                Long n = Long.parseLong(st.nextToken());
                list.add(n);
            }

            Long count = 0L;
            Long max = Long.MIN_VALUE;
            for (int j = list.size() - 1; j >= 0; j--) {
                if (max < list.get(j)) {
                    max = list.get(j);
                } else {
                    count += max - list.get(j);
                }

            }
            sb.append("#").append(i).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}
