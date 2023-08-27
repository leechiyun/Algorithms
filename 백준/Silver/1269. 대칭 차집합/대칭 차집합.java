import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> A = new HashMap<>();
        Map<Integer, Integer> B = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A.put(Integer.parseInt(st.nextToken()), 1);
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            B.put(Integer.parseInt(st.nextToken()), 1);
        }

        // A-B => A
        List<Integer> aSet = A.keySet().stream().collect(Collectors.toList());
        List<Integer> bSet = B.keySet().stream().collect(Collectors.toList());
        for (int i = 0; i < M; i++) {
            if(A.containsKey(bSet.get(i))){
                A.remove(bSet.get(i));
            }
        }
        for (int i = 0; i < N; i++) {
            if(B.containsKey(aSet.get(i))){
                B.remove(aSet.get(i));
            }
        }

        System.out.println(A.size() + B.size());
    }
}