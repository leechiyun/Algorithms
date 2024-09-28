class Solution {
    static int max = Integer.MIN_VALUE;
    static int min = 1;
    
    static int ds[];
    static int ts[];
    static long l;
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        ds = diffs;
        ts = times;
        l = limit;
        
        for(int diff: diffs) {
            max = Math.max(max, diff);
        }
        
        // 이분 탐색
        int mid = 0;
        long n;
        while(min <= max) {
            mid = (min + max) / 2;
            
            n = calc(mid);
            
            // limit 전이면 왼쪽
            if(n > limit) {
                min = mid + 1;
            } else{
                max = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
    
    public long calc(int level) {
        int len = ds.length;
        long sum = 0;
        
        int prev = 0;
        int d;
        int t;
        for(int i = 0; i < len; i++) {
            d = ds[i];
            t = ts[i];
            prev = i > 0 ? ts[i-1]:0;
            
            if(d <= level) {
                sum += t;
            } else {
                sum += (d - level) * (t + prev) + t;
            }
        }
        
        return sum;
    }
}