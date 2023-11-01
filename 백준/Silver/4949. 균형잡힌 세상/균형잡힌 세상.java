import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (!input.equals(".")){
            boolean flag = true;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if(c == '('){
                    stack.push(c);
                } else if (c == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                } else if (c == '[') {
                    stack.push(c);
                } else if (c == ']') {
                    if(!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag && stack.isEmpty()){
                sb.append("yes").append("\n");
            }else{
                sb.append("no").append("\n");
            }

            input = br.readLine();
        }
        System.out.println(sb);
    }
}

