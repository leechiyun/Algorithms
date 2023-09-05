import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static Deque<Integer> input = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input.add(Integer.parseInt(st.nextToken()));
        }

        Stack<Integer> wait = new Stack<>();
        int count = 1;

        // 순서에 따라 재배치
        while (!input.isEmpty()) {
            if (input.getFirst() == count) {
                input.poll();
                count++;
            } else {
                if (!wait.isEmpty() && wait.get(wait.size() - 1) == count) {
                    wait.pop();
                    count++;
                } else {
                    wait.push(input.poll());
                }
            }
        }
        boolean flag = true;
        while (!wait.isEmpty()) {
            int num = wait.pop();

            if (num == count) {
                count++;
            } else {
                flag = false;
                break;
            }
        }

        System.out.println(flag && N == count - 1 ? "Nice" : "Sad");
    }
}