import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());


        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            if(command == 1){
                stack.add(Integer.parseInt(st.nextToken()));
            } else if (command == 2) {
                sb.append(stack.isEmpty()? -1 : stack.pop()).append("\n");
            } else if (command == 3) {
                sb.append(stack.size()).append("\n");
            } else if (command == 4) {
                sb.append(stack.isEmpty()? 1 : 0).append("\n");
            } else if (command == 5) {
                sb.append(stack.isEmpty()? -1 : stack.get(stack.size()-1)).append("\n");
            }
        }
        System.out.println(sb);
    }
}