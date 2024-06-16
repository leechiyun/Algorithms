import java.util.*;

class Solution {
    int left[] = {2, 3, 4};
    int right[] = {2, 3, 4};
    
    // 1. 정렬
    // 2. left * w = right * x
    //    x = (left * w) / right
    public long solution(int[] weights) {
        Arrays.sort(weights);
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int w: weights) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        long result = 0;
        for(int w: weights) {
            // 자기자신의 뺀다
            map.put(w, map.get(w) - 1);
            
            Set<Integer> set = new HashSet<>();
            for(int l: left) {
                for(int r: right) {
                    double x = (double)(w * r) / l;
                    
                    if(x == (int) x) {
                        set.add((int)x);
                    }
                }
            }
            
            // System.out.println(set);
            for(int n: set) {
                result += map.getOrDefault(n, 0);
            }
            
            // 나중에 더한다
            // map.put(w, map.get(w) + 1);
        }

        return result;
    }
}