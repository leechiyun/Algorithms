import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for(int num: scoville) {
            pq.offer(num);
        }
        
        int answer = 0;
        while(!pq.isEmpty()){
            int num1 = pq.poll();   // 가장 맵지 않은 음식 스코빌 지수
            
            while(num1 < K && pq.size() > 0) {
                int num2 = pq.poll();   // 두 번째로 맵지 않은 음식의 스코빌 지수
                
                pq.offer(num1 + (num2 * 2));
                num1 = pq.poll();
                answer++;
            }
            
            if(num1 < K) {
                return -1;
            }
        }
        
        return answer;
    }
}