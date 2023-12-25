import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int H = park.length;
        int W = park[0].length();
        
        // 시작지점 찾기
        int x = 0;
        int y = 0;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                if(park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        
        for(String route: routes) {
            StringTokenizer st = new StringTokenizer(route, " ");
            
            String op = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            
            int nextX = x;
            int nextY = y;

            if(op.equals("E")) {
                nextY += n;
            } else if(op.equals("W")) {
                nextY -= n;
            } else if(op.equals("N")) {
                nextX -= n;
            } else if(op.equals("S")) {
                nextX += n;
            }
            
            // 공원 벗어나는지, 이동중 장애물이 있는지 확인
            boolean flag = true;
            if(nextX >= 0 && nextX < H && nextY >= 0 && nextY < W) {
                int startX = x;
                int endX = nextX;
                int startY = y;
                int endY = nextY;
                
                if(x > nextX) {
                    startX = nextX;
                    endX = x;
                }
                if(y > nextY) {
                    startY = nextY;
                    endY = y;
                }
                
                for(int i = startX; i <= endX; i++) {
                    for(int j = startY; j <= endY; j++) {
                        if(park[i].charAt(j) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                }
                
                if(flag) {
                    x = nextX;
                    y = nextY;
                }
            }
        }
        
        int[] answer = {x, y};
        return answer;
    }
}