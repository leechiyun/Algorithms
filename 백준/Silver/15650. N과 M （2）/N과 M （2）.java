import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M];
        visited = new boolean[N + 1];

        combination(1, 0);

        br.close();
    }

    static void combination(int start, int depth) {
        if (depth == M) {
            for (int num : selected) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = i;
                combination(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}