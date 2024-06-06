import java.util.*;

class Solution {
    
    static char map[][];
    static int N, M;
    
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    
    static class Node {
        int x, y;
        int cnt;
        int key;       // 0: 레버 열지 못함, 1: 레버 열음
        
        public Node(int x, int y, int cnt, int key) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.key = key;
        }
    }
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        Node start = null;
        Node end = null;
        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                char c = maps[i].charAt(j);
                
                if(c == 'S') {
                    start = new Node(i, j, 0, 0);
                }
                if(c == 'E') {
                    end = new Node(i, j, 0, 0);
                }
                
                map[i][j] = c;
            }
        }
        
        Queue<Node> q = new ArrayDeque<>();
        q.offer(start);
        boolean visited[][][] = new boolean[2][N][M];
        visited[0][start.x][start.y] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            if(cur.x == end.x && cur.y == end.y && cur.key == 1) {
                return cur.cnt;
            }
            
            for(int d = 0; d < dx.length; d++) {
                int nextX = cur.x + dx[d];
                int nextY = cur.y + dy[d];
                
                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M
                    && !visited[cur.key][nextX][nextY] && map[nextX][nextY] != 'X') {
                    // 레버인 경우
                    if(map[nextX][nextY] == 'L') {
                        q.offer(new Node(nextX, nextY, cur.cnt + 1, 1));
                        visited[1][nextX][nextY] = true;
                    } else {
                        q.offer(new Node(nextX, nextY, cur.cnt + 1, cur.key));
                        visited[cur.key][nextX][nextY] = true;
                    }
                    
                } 
            }
        }
        
        return -1;
    }
}