import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static boolean visited[];
    static List<String> list = new ArrayList<>();
    static String strArr[] = new String[]{"+", "-", "*", "/"};
    static int inputArr[];
    static List<Integer> sumList = new ArrayList<>();
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        inputArr = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                list.add(strArr[i]);
            }
        }
        String output[] = new String[N];
        permutation(output, N, 0);

        System.out.println(Collections.max(sumList));
        System.out.println(Collections.min(sumList));
    }

    private static void permutation(String[] output, int N, int depth) {
        if(depth == N-1){
            sum = inputArr[0];
            for (int i = 1; i < N; i++) {
                String o = output[i-1];
                if(o.equals("+")){
                    sum += inputArr[i];
                } else if (o.equals("-")) {
                    sum -= inputArr[i];
                } else if (o.equals("*")) {
                    sum *= inputArr[i];
                } else if (o.equals("/")) {
                    sum /= inputArr[i];
                }
            }
            sumList.add(sum);

            return;
        }

        for (int i = 0; i < N-1; i++) {
            if(!visited[i]){
                visited[i] =true;
                output[depth] = list.get(i);
                permutation(output, N, depth + 1);
                visited[i] = false;
            }

        }
    }
}