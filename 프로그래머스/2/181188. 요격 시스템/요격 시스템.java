import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> {
            if(a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        int end = targets[0][1];
        int result = 1; // 첫 번째로 만들어지는 요격 시스템
        
        for(int[] target: targets) {
            if(end <= target[0]) {
                end = target[1];
                result++;
            }
        }
        
        
        return result;
    }
}