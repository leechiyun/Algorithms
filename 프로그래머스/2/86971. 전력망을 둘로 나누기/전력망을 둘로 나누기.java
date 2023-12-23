import java.util.*;

class Solution {
    static List<Integer>[] lists;
    
    static class Node {
        int node;
        int count;
    }
    
    public int solution(int n, int[][] wires) {
        lists = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        
        // 양방향 간선 추가
        for(int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            lists[v1].add(v2);
            lists[v2].add(v1);
        }
        
        List<Integer> results = new ArrayList<>();
        for(int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
 
            // 해당 간선을 그래프에서 제거
            lists[v1].remove(Integer.valueOf(v2));
            lists[v2].remove(Integer.valueOf(v1));
            
            // bfs
            boolean[] visited = new boolean[n + 1];
            
            int count = 1;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(v1);
            visited[v1] = true;
            
            while(!queue.isEmpty()){
                int node = queue.poll();
                
                for(int j = 0; j < lists[node].size(); j++) {
                    int nextNode = lists[node].get(j);
                    
                    if(!visited[nextNode]) {
                        visited[nextNode] = true;
                        queue.offer(nextNode);
                        count++;
                    }
                }
            }
            
            results.add(Math.abs(n - 2 * count));
            
            // 그래프에 다시 추가
            lists[v1].add(v2);
            lists[v2].add(v1);
        }
        
        return Collections.min(results);
    }
}