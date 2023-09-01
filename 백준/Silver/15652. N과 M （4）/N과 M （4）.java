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
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[r];

        // 조합(시작점, 깊이, 찾을 개수(r))
        perm(0, 0);
    }

    private static void perm(int idx, int depth) {
        if(depth == r){
            StringBuilder sb =new StringBuilder();
            for (int i = 0; i < r; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = idx; i < N; i++) {
            arr[depth] = i+1;
            perm(i, depth+1);
        }
    }
}