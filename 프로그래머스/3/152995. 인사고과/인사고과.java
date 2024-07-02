import java.util.*;

class Solution {
    class Score {
        int x, y;
        int sum;
        
        public Score(int x, int y) {
            this.x = x;
            this.y = y;
            this.sum = x + y;
        }
        
        public String toString() {
            return this.x + " + " + this.y + " = " + this.sum;
        }
    }
    
    public int solution(int[][] scores) {
        int x = scores[0][0];
        int y = scores[0][1];
        
        Arrays.sort(scores, (a, b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        
        PriorityQueue<Score> result = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b.sum, a.sum);
        });
        
        // 동료 평가 점수만 확인
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < scores.length; i++) {
            if(scores[i][1] >= max) {
                max = scores[i][1];
                result.offer(new Score(scores[i][0], scores[i][1]));
            }
        }
        
        int rank = 0;
        while(!result.isEmpty()) {
            rank++;
            Score cur = result.poll();
            
            if(cur.x == x && cur.y == y) {
                return rank;
            }
            
            while(!result.isEmpty() && cur.sum == result.peek().sum) {
                cur = result.poll();
                
                if(cur.x == x && cur.y == y) {
                    return rank;
                }
                
                rank++;
            }
        }
        
        return -1;
    }
}