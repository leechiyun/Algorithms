import java.util.*;

class Solution {
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    
    static char map[][];
    static int N, M;
    
    static class Node {
        int x, y;
        int cnt;
        
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        
        Node start = null;
        Node end = null;
        map = new char[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++) {
                char c = board[i].charAt(j);
                
                if(c == 'R') {
                    start = new Node(i, j, 0);
                }
                if(c == 'G') {
                    end = new Node(i, j, 0);
                }
                
                map[i][j] = c;
            }
        }
        
        Queue<Node> q = new ArrayDeque<>();
        q.offer(start);
        boolean visited[][] = new boolean[N][M];
        visited[start.x][start.y] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            if(cur.x == end.x && cur.y == end.y) {
                return cur.cnt;
            }
            
            for(int d = 0; d < dx.length; d++) {
                // 갈 수 있는 곳까지 간다.
                int nextX = cur.x + dx[d];
                int nextY = cur.y + dy[d];
                
                while(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M
                        && map[nextX][nextY] != 'D') {
                    nextX += dx[d];
                    nextY += dy[d];
                }
                
                nextX -= dx[d];
                nextY -= dy[d];
                
                if(!visited[nextX][nextY]) {
                    q.offer(new Node(nextX, nextY, cur.cnt + 1));
                    visited[nextX][nextY] = true;
                }
            }
        }
        
        return -1;
    }
}