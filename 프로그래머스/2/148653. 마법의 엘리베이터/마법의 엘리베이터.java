import java.util.*;

class Solution {
    int dp[];
    
    // 0층이 가장 아래
    public int solution(int storey) {
        dp = new int[10];
        for(int i = 0; i < 10; i++) {
            int plus = i;
            int minus = 10 - i;
            
            dp[i] = Math.min(plus, minus);
        }
        
        int result = 0;
        while(storey > 0) {
            int n = storey % 10;
            int nextN = (storey / 10) % 10;

            
            if(n > 5 || (n == 5 && nextN >= 5)) {
                storey += 10;
            } 
            
            result += dp[n];
            storey /= 10;
        }

        return result;
    }
}