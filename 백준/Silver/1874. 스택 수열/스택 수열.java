import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        int current = 1; // 스택에 넣을 다음 수
        boolean possible = true; // 수열을 만들 수 있는지 여부
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            while (current <= num) {
                stack.push(current);
                sb.append("+\n");
                current++;
            }
            
            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }
        
        if (possible) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
