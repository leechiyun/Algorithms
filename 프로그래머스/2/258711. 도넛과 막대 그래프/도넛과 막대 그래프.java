import java.util.*;

class Solution {
    class Node {
        List<Integer> in;
        List<Integer> out;
        
        public Node(List<Integer> in, List<Integer> out) {
            this.in = in;
            this.out = out;
        }
        
        public String toString() {
            return this.in + " " + this.out;
        }
    }
    
    static Map<Integer, Node> map = new HashMap<>();
    static int N;
    
    // 각 노드들의 들어오는거 나가는걸로 파악 가능
    // 1. 나가는 거 1개, 들어오는 것 1개씩 : 도넛
    // 2. 나가는 것만 1개식 : 막대
    // 3. 가운데 노드가 들어오는거 2개, 나가는거 2개 : 8자 모형
    // 4. 나가는 것만 2개 이상 : 가운데 정점
    public int[] solution(int[][] edges) {
        for(int edge[]: edges) {
            int x = edge[0];
            int y = edge[1];
            
            // 나가는 거
            if(!map.containsKey(x)) {
                map.put(x, new Node(new ArrayList<>(), new ArrayList<>()));
            }
            // 들어오는 거
            if(!map.containsKey(y)) {
                map.put(y, new Node(new ArrayList<>(), new ArrayList<>()));
            }
            
            map.get(x).out.add(y);
            map.get(y).in.add(x);
        }
        
        // 나가는 것만 2개 이상인 정점이 가운데 값
        int center = 0;
        int 도넛 = 0;  // 도넛
        int 막대 = 0;  // 막대
        int 모양 = 0;  // 8자모양
        for(int key: map.keySet()) {
            Node cur = map.get(key);
            if(cur.out.size() >= 2 && cur.in.size() == 0) {
                center = key;
            }
            
            // 들어오는 거 2개 이상, 나가는거 2개 이상
            if(cur.in.size() >= 2 && cur.out.size() >= 2){
                모양++;
            }
        }

        // center와 연결된 노드를 찾고, 조건에 따라 분류한다.
        int total = map.get(center).out.size();
        for(int n: map.get(center).out) {
            // 막대인지 확인
            boolean flag = true;
            
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(n);
            while(!q.isEmpty()) {
                int cur = q.poll();
                
                if(visited.contains(cur)) {
                    flag = false;
                    break;
                }
                visited.add(cur);
                
                for(int next: map.get(cur).out) {
                    q.offer(next);
                }
            }
            
            if(flag) {
                막대++;
            }
        }
        
        
        int[] answer = {center, (total - 막대 - 모양), 막대, 모양};
        return answer;
    }
}