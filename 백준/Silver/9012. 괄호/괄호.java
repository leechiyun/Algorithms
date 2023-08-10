import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            char charArr[] = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean answer = true;
            for (int j = 0; j < charArr.length; j++) {
                if(charArr[j] == '('){
                    stack.push(charArr[j]);
                } else if (charArr[j] == ')') {
                    if(stack.isEmpty()){
                        answer = false;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty())    answer = false;
            sb.append(answer ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}