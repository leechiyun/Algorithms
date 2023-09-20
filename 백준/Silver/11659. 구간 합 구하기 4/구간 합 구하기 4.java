import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // list: 구간합
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        list.add(0);
        for (int i = 1; i <= N; i++) {
            list.add(list.get(i - 1) + Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(list.get(end) - list.get(start - 1)).append("\n");
        }

        System.out.println(sb);
    }
}

