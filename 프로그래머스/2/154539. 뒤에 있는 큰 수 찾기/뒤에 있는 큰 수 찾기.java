import java.util.*;

class Solution {
    
    // 해시맵을 활용해 자신보다 큰 수가 있으면 update
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];
        answer[N-1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(numbers[N-1]);
        
        start: for(int i = N-2; i >= 0; i--) {
            int n = numbers[i];
            
            while(!stack.isEmpty()) {
                if(n < stack.peek()) {
                    answer[i] = stack.peek();
                    stack.push(n);
                    continue start;
                }
                
                stack.pop();
            }
            
            answer[i] = -1;
            stack.push(n);
        }
        
        
        return answer;
    }
}