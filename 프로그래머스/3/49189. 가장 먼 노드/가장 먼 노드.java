import java.util.*;

class Solution {
    static boolean[] visited;

    public int solution(int n, int[][] edge) {
        // 그래프 탐색
        // 1. 양방향 그래프 저장
        // 2. BFS를 활용하여 탐색
    
        // 1. 양방향 그래프 저장
        visited = new boolean[n+1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for(int[] vertex: edge) {
            int n1 = vertex[0];
            int n2 = vertex[1];
            
            map.get(n1).add(n2);
            map.get(n2).add(n1);
        }
        
        int start = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        
        int max = 0;
        Map<Integer, Integer> results = new HashMap<>();
        while(!queue.isEmpty()) {
            int curNode = queue.poll();
            
            for(int nextNode: map.get(curNode)) {
                if(!visited[nextNode]) {
                    int nextCount = results.getOrDefault(curNode, 0) + 1;
                    if(max < nextCount) {
                        max = nextCount;
                    }
                    
                    queue.offer(nextNode);
                    results.put(nextNode, nextCount);
                    visited[nextNode] = true;
                }
            }
            
        }
        
        int count = 0;
        for(int key: results.keySet()) {
            if(max == results.get(key)) {
                count++;
            }
        }
        
        return count;
    }
}