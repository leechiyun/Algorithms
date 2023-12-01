import java.util.*;

class Solution {
    static int N = 0;
    static int M = 0;
    static boolean visited[][];
    static int maps[][];
    static List<Integer> results = new ArrayList<>();
    
    // 방향
    static int dx[] = new int[] {0, -1, 0, 1};
    static int dy[] = new int[] {-1, 0, 1, 0};
    
    public static class Node{
        int x, y;
        int count = 0;
        
        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public int solution(int[][] maps) {
        this.maps = maps;
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            Node curNode = queue.poll();
            
            // 도착지에 도달한 경우
            if(curNode.x == N - 1 && curNode.y == M - 1) {
                results.add(curNode.count);
            }
            
            for(int i = 0; i < dx.length; i++){
                int nextX = curNode.x + dx[i];
                int nextY = curNode.y + dy[i];
                
                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M 
                   && !visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                    queue.offer(new Node(nextX, nextY, curNode.count + 1));
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