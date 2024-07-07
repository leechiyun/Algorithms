import java.util.*;

class Solution {
    // 토핑은 4가지 (1, 2, 3, 4)
    public int solution(int[] topping) {
        Map<Integer, Integer> ml = new HashMap<>();
        Map<Integer, Integer> mr = new HashMap<>();
        
        for(int t: topping) {
            mr.put(t, mr.getOrDefault(t, 0) + 1);
        }
        
        // left의 값을 하나씩 넣어보며 서로의 짝이 맞는지 확인
        int result = 0;
        for(int t: topping) {
            // ml 추가
            ml.put(t, ml.getOrDefault(t, 0) + 1);
            
            // mr 제거
            mr.put(t, mr.getOrDefault(t, 0) - 1);
            if(mr.get(t) <= 0) {
                mr.remove(t);
            }
            
            if(ml.size() == mr.size()) {
                result++;
            }
        }

        return result;
    }
}