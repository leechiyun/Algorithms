import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> results = new ArrayList<>();

        for(int command[]: commands) {
            int start = command[0] - 1;
            int end = command[1] - 1;
            int idx = command[2] - 1;

            List<Integer> sortedList = new ArrayList<>();
            for(int i=start; i<=end; i++){
                sortedList.add(array[i]);
            }
            Collections.sort(sortedList);
            
            results.add(sortedList.get(idx));
        }
        
        int[] answer = new int[results.size()];
        for(int i = 0; i < results.size(); i++){
            answer[i] = results.get(i);
        }
        return answer;
    }
}