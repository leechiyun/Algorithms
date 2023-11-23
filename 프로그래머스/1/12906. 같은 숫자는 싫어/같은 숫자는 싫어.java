import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        list.add(arr[0]);

        for(int num: arr) {
            if(stack.peek() != num){
                list.add(num);
            }
            stack.push(num);
        }
        
        // list -> Array
        int answer[] = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}