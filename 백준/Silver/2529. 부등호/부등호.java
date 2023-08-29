import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int minArr[];
    static int maxArr[];
    static int minOutput[];
    static int maxOutput[];
    static List<int[]> result = new ArrayList<>();
    static boolean visited[];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        // 초기화
        minArr = new int[N+1];
        maxArr = new int[N+1];
        minOutput = new int[N+1];
        maxOutput = new int[N+1];
        visited = new boolean[N+1];

        String str[] = new String[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            str[i] = st.nextToken();
        }

        for (int i = 0; i <= N; i++) {
            minArr[i] = i;
            maxArr[i] = 9 - i;
        }

        perm(0, minArr, minOutput);
        perm(0, maxArr, maxOutput);

        // result 부등호 비교
        List<String> list = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < N; j++) {
                if (str[j].equals(">")) {
                    if (result.get(i)[j] <= result.get(i)[j + 1]) {
                        flag = false;
                        break;
                    }
                } else {
                    if (result.get(i)[j] >= result.get(i)[j + 1]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                StringBuilder sb = new StringBuilder();
                for (int value : result.get(i)) {
                    sb.append(value);
                }
                list.add(sb.toString());
            }
        }
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }

    private static void perm(int depth, int input[], int output[]) {
        if (depth == N + 1 ) {
            int arr[] = new int[N+1];
            for (int i = 0; i <= N; i++) {
                arr[i] = output[i];
            }
            result.add(arr);
            return;
        }

        for (int i = 0; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = input[i];
                perm(depth + 1, input, output);
                visited[i] = false;
            }
        }
    }
}