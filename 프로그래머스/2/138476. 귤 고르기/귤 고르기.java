import java.util.*;

class Solution {
    class Node { 
        int k, v;
        
        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
        
        public String toString() {
            return this.k + " "  + this.v;
        }
    }
    
    Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int k, int[] tangerine) {
        for(int t: tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        // max 찾기
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b.v, a.v);
        });
        for(int key: map.keySet()){
            pq.offer(new Node(key, map.get(key)));
        }
        
        int result = 0;
        int i = 0;
        while(!pq.isEmpty()) {
            if(i >= k) {
                return result;
            }
            
            Node cur = pq.poll();
            
            i += map.get(cur.k);
            
            result++;
        }
        
        return result;
    }
}