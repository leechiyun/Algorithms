import java.util.*;

class Solution {
    public int solution(int[] citations) {
        List<Integer> list = new ArrayList<>();
        for(int citation: citations) {
            list.add(citation);
        }
        
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            int h = list.size() - i;
            
            if(list.get(i) >= h) {
                return h;
            }
        }
        
        int answer = 0;
        return answer;
    }
}