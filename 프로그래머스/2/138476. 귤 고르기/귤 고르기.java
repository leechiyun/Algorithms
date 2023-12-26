import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 종류별 귤의 갯수
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> tangerines = new ArrayList<>(map.keySet());
        Collections.sort(tangerines, (a, b) -> map.get(b) - map.get(a));
        
        int sum = 0;
        int answer = 0;
        for(int i = 0; i < tangerines.size(); i++) {
            sum += map.get(tangerines.get(i));
            answer++;
            
            if(sum >= k) {
                return answer;
            }
        }
        
        return answer;
    }
}