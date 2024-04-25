import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static String[] words;
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        visited = new boolean[26];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // 필수로 가르쳐야 하는 글자 'a', 'n', 't', 'i', 'c' 체크
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        if (K < 5) {
            System.out.println(0);
        } else {
            dfs(0, 5);
            System.out.println(max);
        }
    }

    // 모든 글자 조합 완전 탐색
    static void dfs(int index, int count) {
    	// 탈출 조건, 최대 가르칠 수 있는 K
        if (count == K) {
            int cnt = 0;
            for (String word : words) {
                boolean isReadable = true;
                for (char c : word.toCharArray()) {
                    if (!visited[c - 'a']) {
                        isReadable = false;
                        break;
                    }
                }
                if (isReadable) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
            return;
        }

        // 글자 'a' ~ 'z'
        for (int i = index; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
}