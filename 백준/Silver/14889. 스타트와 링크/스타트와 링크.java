import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int arr[][];
    static boolean visited[];
    static int N;
    static int min = Integer.MAX_VALUE;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 조합(시작점, 깊이, 찾을 개수(r))
        perm(0, 0);
        System.out.println(min);
    }

    private static void perm(int idx, int depth) {
        if(depth == N/2){
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]){
                visited[i] = true;
                perm(i, depth+1);
                visited[i] = false;
            }
        }
    }

    // 값 비교 후 작은 값 출력
    private static void diff(){
        int a=0, b=0;

        for (int i = 0; i <N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if(visited[i] && visited[j]){
                    a += arr[i][j] + arr[j][i];
                } else if (!visited[i] && !visited[j]){
                    b += arr[i][j] + arr[j][i];
                }
            }
        }

        int result = Math.abs(a - b);
        if(min > result)    min = result;
        if(min == 0){
            System.out.println(0);
            System.exit(0);
        }
    }
}