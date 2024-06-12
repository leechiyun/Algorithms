import java.util.*;

class Solution {
    
    static class Node {
        int x, y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    
    // 0: 갈 수 없는 곳(바다)
    // 1~9: 섬(식량)
    static int map[][];
    static int N, M;
    
    static boolean visited[][];
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                char c = maps[i].charAt(j);
                
                if(c != 'X') {
                    map[i][j] = c - '0';
                }
            }
        }
        
        // 시작점 찾기
        PriorityQueue<Integer> result = new PriorityQueue<>();
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] > 0) {
                    // BFS 구현
                    Node start = new Node(i, j);
                    Queue<Node> q = new ArrayDeque<>();
                    q.offer(start);
                    visited[i][j] = true;
                    
                    int sum = 0;
                    while(!q.isEmpty()) {
                        Node cur = q.poll();
                        
                        sum += map[cur.x][cur.y];
                        
                        for(int d = 0; d < dx.length; d++) {
                            int nx = cur.x + dx[d];
                            int ny = cur.y + dy[d];
                            
                            if(nx >= 0 && nx < N && ny >= 0 && ny < M
                                && !visited[nx][ny] && map[nx][ny] > 0) {
                                q.offer(new Node(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    
                    result.offer(sum);
                }
            }
        }
        
        if(result.isEmpty()) {
            return new int[] {-1};
        }
        
        int[] answer = new int[result.size()];
        int i = 0;
        while(!result.isEmpty()){
            answer[i] = result.poll();
            i++;
        }
        
        return answer;
    }
}