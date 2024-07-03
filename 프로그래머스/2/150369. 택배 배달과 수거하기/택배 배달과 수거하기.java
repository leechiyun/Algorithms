import java.util.*;

class Solution {
    class House {
        int d, p;
        
        public House(int d, int p) {
            this.d = d;
            this.p = p;
        }
    }
    
    // 전체 갯수
    // 1. 배답 집 마지막 위치, 수거 집 마지막 위치
    // 2. 배달 -> 수거 (위치 저장)
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int rd = 0;
        int rp = 0;
        int sumD = 0;
        int sumP = 0;
        
        for(int i = 0; i < n; i++) {
            if(deliveries[i] > 0) {
                rd = i;
                sumD += deliveries[i];
            }
            
            if(pickups[i] > 0) {
                rp = i;
                sumP += pickups[i];
            }
        }
        
        long result = 0;
        while(sumD > 0 || sumP > 0) {
            result += Math.max(rd + 1, rp + 1) * 2;
            
            // 배달 진행
            int cnt = cap;
            int idx = rd;
            while(cnt > 0 && rd >= 0) {
                int d = deliveries[rd];
                if(d > 0) {
                    if(cnt >= d) {
                        deliveries[rd] = 0;
                        cnt -= d;
                        sumD -= d;
                    } else {
                        deliveries[rd] -= cnt;
                        sumD -= cnt;
                        cnt = 0;
                    }
                }
                
                // rd 위치 조정
                while(rd >= 0 && deliveries[rd] == 0) {
                    rd--;
                }
            }
            
            // 수거 진행
            cnt = cap;
            idx = rp;
            while(cnt > 0 && rp >= 0) {
                int p = pickups[rp];
                if(p > 0) {
                    if(cnt >= p) {
                        pickups[rp] = 0;
                        cnt -= p;
                        sumP -= p;
                    } else {
                        pickups[rp] -= cnt;
                        sumP -= cnt;
                        cnt = 0;
                    }
                }
                
                // rd 위치 조정
                while(rp >= 0 && pickups[rp] == 0) {
                    rp--;
                }
            }
        }
        
        return result;
    }
}