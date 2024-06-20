import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, K, M;
    static LinkedList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        // K번째 순서를 계속해서 제거 후, M명 제거 후 방향 반대
        int idx = 0;
        int cnt = 0;    // 제거한 수
        boolean flag = true;    // true: 정방향, false: 역방향
        while (!list.isEmpty()) {
            if(cnt != 0 && cnt % M == 0) {
                flag = !flag;
            }

            if(flag) {
                idx = (idx + (K - 1)) % list.size();
            } else {
                idx = (idx - K) % list.size();
                idx = idx < 0 ? idx + list.size(): idx;
            }

            // 1. 제거
            sb.append(list.get(idx) + "\n");
            list.remove(idx);

            cnt++;
        }

        System.out.println(sb);
    }
}