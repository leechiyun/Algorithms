import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static List<Integer> list = new ArrayList<>();
    static boolean visited[];
    static int N, M;
    static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        combination(0, 0);

        System.out.println(Collections.max(resultList));
    }

    private static void combination(int start, int depth) {
        
        // DFS 탈출 조건
        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                if (visited[i]) {
                    sum += list.get(i);
                }
            }

            if (sum <= M){
                resultList.add(sum);
            }

            return;
        }

        for (int i = start; i < list.size(); i++) {
            if(!visited[i]){
                visited[i] = true;
                combination(i+1, depth+1);
                visited[i] = false;
            }
        }
    }
}

