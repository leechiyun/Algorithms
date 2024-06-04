import java.util.*;

class Solution {
    
    // 원 쿠션을 상, 하, 좌, 우만 만들 수 있다.
    // 각각의 원 쿠션 거리 값을 구하고 비교하여 최소값을 저장한다.
    // ! 원 쿠션을 할 수 없는 경우가 있다 (진행 방향에 공이 있는 경우)
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            
            int min = Integer.MAX_VALUE;
            
            // 상
            if(!(startX == targetX && targetY > startY)) {
                min = Math.min(min, calculateDistance(Math.abs(startX - targetX), 2 * n - startY - targetY));
            }
            // 하
            if(!(startX == targetX && targetY < startY)) {
                min = Math.min(min, calculateDistance(Math.abs(startX - targetX), startY + targetY));
            }
            // 좌
            if(!(startX > targetX && targetY == startY)) {
                min = Math.min(min, calculateDistance(startX + targetX, Math.abs(startY - targetY)));
            }
            // 우
            if(!(startX < targetX && targetY == startY)) {
                min = Math.min(min, calculateDistance(2 * m - startX - targetX, Math.abs(startY - targetY)));
            }
            
            answer[i] = min;
        }
        
        return answer;
    }
    
    static int calculateDistance(int x, int y) {
        return (int)Math.pow(x, 2) + (int)Math.pow(y, 2);
    }
}