import java.util.*;

class Solution {
    static List<Integer> graph[];
    
    public int solution(int n, int[][] wires) {
        graph = new List[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] wire: wires) {
            int x = wire[0];
            int y = wire[1];
            
            graph[x].add(y);
            graph[y].add(x);
        }
        
        int min = Integer.MAX_VALUE;
        for(int[] wire: wires) {
            int x = wire[0];
            int y = wire[1];
            
            // 1. 연결 끊기
            graph[x].remove(Integer.valueOf(y));
            graph[y].remove(Integer.valueOf(x));
            
            // BFS 구현
            boolean visited[] = new boolean[n + 1];
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(1);
            visited[1] = true;
            int cnt = 1;
            while(!q.isEmpty()) {
                int cur = q.poll();
                
                for(int next:graph[cur]) {
                    if(!visited[next]) {
                        q.offer(next);
                        visited[next] = true;
                        cnt++;
                    }
                }
            }
            
            min = Math.min(min, Math.abs((n - cnt) - cnt));
            
            // 2. 다시 연결
            graph[x].add(y);
            graph[y].add(x);
        }
        
        return min;
    }
}