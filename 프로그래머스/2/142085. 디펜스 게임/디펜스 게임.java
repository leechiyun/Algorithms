import java.util.*;

class Solution {
    static int[] es;
    static int max;
    static int cnt = 0;
    
    public int solution(int n, int k, int[] enemy) {
        es = enemy;
        
        // 이진 탐색 구현
        // 1. 판단 기준은 : n과 k를 사용해 현재 위치에서 가능한가
        int l = 0;
        int r = es.length;
        int mid = 0;
        while(l <= r) {
            mid = (l + r) / 2;
            
            // 가능한지 확인
            if(isValid(n, k, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        } 
        
        return r;
    }
    
    boolean isValid(int n, int k, int l) {
        if(l > es.length)
            return false;
        
        int arr[] = Arrays.copyOf(es, l);
        
        Arrays.sort(arr);
        
        long sum = 0;
        for(int i = 0; i < l - k; i++) {
            sum += arr[i];
        }
        
        return sum <= n;
    }
    
//     void dfs(int round, int n, int k) {
//         cnt++;
//         System.out.println("round : " + round + ", " + n + " " + k);
        
//         // 1. 무적 사용
//         if(k > 0) {
//             dfs(round + 1, n, k - 1);
//         }
        
//         if(round >= es.length || n < es[round]) {
//             max = Math.max(max, round);
            
//             return;
//         }
        
//         // 2. 무적 없이
//         dfs(round + 1, n - es[round], k);
//     }
}