import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int arr[];
    static int N;
    static int r;
    static StringBuilder sb =new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[r];

        // 조합(시작점, 깊이, 찾을 개수(r))
        perm(0);
        System.out.println(sb);
    }

    private static void perm(int depth) {
        if(depth == r){
            for (int i = 0; i < r; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i+1;
            perm(depth+1);
        }
    }
}