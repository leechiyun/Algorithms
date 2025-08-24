class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int level = right;
        
        int len = diffs.length;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            
            for(int i = 0; i < len; i++) {
                int d = diffs[i];
                int pt = 0;
                if(i > 0) {
                    pt = times[i-1];
                }
                int ct = times[i];
                
                sum += calc(d, pt, ct, mid);
            }
            
            if(sum <= limit){
                level = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return level;
    }
    
    public int calc(int diff, int prev, int cur, int level) {
        if(level >= diff) {
            return cur;
        }
        
        int n = diff - level;
        return cur + ((cur + prev) * n);
    }
}