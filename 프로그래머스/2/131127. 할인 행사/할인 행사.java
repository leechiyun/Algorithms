import java.util.*;

class Solution {
    static final int N = 10;
    
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        int answer = 0;
        for(int i = 0; i <= discount.length - N; i++) {
            Map<String, Integer> shop = new HashMap<>();
            for(int j = i; j < i + N; j++) {
                shop.put(discount[j], shop.getOrDefault(discount[j], 0) + 1);
            }

            boolean flag = true;
            for(String key: map.keySet()) {
                if(map.getOrDefault(key, 0) != shop.getOrDefault(key, 0)) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                answer++;
            }
        }
        
        return answer;
    }
}