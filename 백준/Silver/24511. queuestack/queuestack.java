import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<Integer> checkQS = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            checkQS.add(Integer.parseInt(st.nextToken()));
        }

        int inputArr[] = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> QSList = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if(checkQS.get(i) == 0){
                QSList.add(inputArr[i]);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            QSList.addFirst(Integer.parseInt(st.nextToken()));

            sb.append(QSList.pollLast()).append(" ");
        }
        System.out.println(sb);

    }
}