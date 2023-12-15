import java.util.*;

class Solution {
    public int solution(int[] order) {
        // 보조 컨테이너 : Stack
        int N = order.length;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        
        int answer = 0;
        for(int orderNumber: order) {
            boolean flag = false;
            if(!stack.isEmpty() && stack.peek() == orderNumber) {
                stack.pop();
                
                answer++;
                flag = true;
                continue;
            }
            
            while(!queue.isEmpty() && queue.peek() != orderNumber) {
                int num = queue.poll();
                
                stack.push(num);
            }
            if(!queue.isEmpty() && queue.peek() == orderNumber) {
                queue.poll();
                
                answer++;
                flag = true;
                continue;
            }
            
            if(!flag) {
                return answer;
            }
        }
        
        
        return answer;
    }
}