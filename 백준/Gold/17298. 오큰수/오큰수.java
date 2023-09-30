import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            list.add(input);
        }

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && list.get(i) >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            stack.push(list.get(i));
        }

        Collections.reverse(result); // 결과 리스트를 뒤집어서 입력 순서대로 출력
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}