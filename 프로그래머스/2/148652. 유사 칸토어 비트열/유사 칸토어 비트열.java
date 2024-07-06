class Solution {
    public int solution(int n, long l, long r) {
        return dfs(n, l, r, 1);
    }
    
    int dfs(int n, long l, long r, long idx) {
        if(n == 0) {
            return 1;
        }
        
        int cnt = 0;
        // 5등분으로 나눌 값
        long v = (long) Math.pow(5, n - 1);
        for(int i = 0; i < 5; i++) {
            // 가운데는 무조건 0
            if(i == 2) {
                continue;
            }
            
            // 범위에서 벗어난 값
            long nextIdx = idx + (i * v);
            if(r < nextIdx || nextIdx + v - 1 < l)
                continue;
            
            cnt += dfs(n - 1, l, r, nextIdx);
            
        }
        
        return cnt;
    }
}