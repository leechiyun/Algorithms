import java.util.*;

class Solution {
    // 상, 하, 좌, 우
    static int dx[] = new int[] {-1, 1, 0, 0};
    static int dy[] = new int[] {0, 0, -1, 1};
    
    static boolean visited[][];
    static int N = 0;
    static int M = 0;
    
    static class Node {
        int x;
        int y;
        int count;
        
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        visited = new boolean[N][M];
        
        Queue<Node> queue = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i].charAt(j) == 'R') {
                    queue.offer(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        
        List<Integer> results = new ArrayList<>();
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            
            if(board[curNode.x].charAt(curNode.y) == 'G') {
                results.add(curNode.count);
            }
            
            for(int i = 0; i < dx.length; i++){
                int nextX = curNode.x + dx[i];
                int nextY = curNode.y + dy[i];
                
                while(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M 
                  && board[nextX].charAt(nextY) != 'D') {
                    nextX += dx[i];
                    nextY += dy[i];
                }
                
                nextX -= dx[i];
                nextY -= dy[i];
                if(!visited[nextX][nextY]) {
                    queue.offer(new Node(nextX, nextY, curNode.count+1));
                    visited[nextX][nextY] = true;
                }
            }
        }
        if(results.isEmpty()) {
            return -1;
        }
        
        return Collections.min(results);
    }
}