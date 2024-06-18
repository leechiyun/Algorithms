import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int N, M;
    static int arrA[], arrB[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        arrA = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        arrB = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Map<Long, Long> mapA = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long sum = 0;
            for (int j = i; j < N; j++) {
                sum += arrA[j];
                mapA.put(sum, mapA.getOrDefault(sum, 0L) + 1);
            }
        }

        Map<Long, Long> mapB = new HashMap<>();
        for (int i = 0; i < M; i++) {
            long sum = 0;
            for (int j = i; j < M; j++) {
                sum += arrB[j];
                mapB.put(sum, mapB.getOrDefault(sum, 0L) + 1);
            }
        }

        long result = 0;
        for (long a: mapA.keySet()) {
            long b = T - a;

            result += mapB.getOrDefault(b, 0L) * mapA.getOrDefault(a, 0L);
        }

        System.out.println(result);
    }
}