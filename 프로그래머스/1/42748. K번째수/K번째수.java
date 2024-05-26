import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int T = commands.length;
        
        int[] answer = new int[T];
        for(int tc = 0; tc < T; tc++) {
            int command[] = commands[tc];
            
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            int len = j - i + 1;
            List<Integer> list = new ArrayList<>();
            for(int c = i - 1; c < j; c++) {
                list.add(array[c]);
            }
            
            Collections.sort(list);
            
            answer[tc] = list.get(k - 1);
        }
        
        
        return answer;
    }
}