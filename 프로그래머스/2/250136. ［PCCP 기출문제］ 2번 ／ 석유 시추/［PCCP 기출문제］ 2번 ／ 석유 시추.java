import java.util.*;

class Solution {
    static int dx[] = {-1, 0, 0, 1};
    static int dy[] = {0, -1, 1, 0};
    
    static boolean visited[][];
    static int N, M;
    
    class Node {
        int x, y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        visited = new boolean[N][M];
        
        // key값으로 석유 저장량 계산
        Map<Integer, Integer> map = new HashMap<>();
        int oilIndex = 0;
        int oils[][] = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            for(int j=0; j<M; j++) {
                if(land[i][j] == 1 && !visited[i][j]){
                    int count = 0;
                    Queue<Node> queue = new ArrayDeque<>();
                    queue.offer(new Node(i, j));
                    visited[i][j] = true;
                    oils[i][j] = oilIndex;
            
                    // BFS 구현
                    while(!queue.isEmpty()) {
                        Node curNode = queue.poll();
                        count++;
                
                        for(int k = 0;  k < dx.length; k++) {
                            int nextX = curNode.x + dx[k];
                            int nextY = curNode.y + dy[k];
                    
                            if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && 
                                land[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                                queue.offer(new Node(nextX, nextY));
                                visited[nextX][nextY] = true;
                                oils[nextX][nextY] = oilIndex;
                            }
                        }
                    }
                    map.put(oilIndex, count);
                    oilIndex++;
                }
            }
        }
        
        
        // 인덱스로 구분해서 Set으로 비교
        Set<Integer> results = new HashSet<>();
        for(int j = 0; j < M; j++) {
            Set<Integer> keySet = new HashSet<>();
            for(int i = 0; i < N; i++) {
                if(visited[i][j]) {
                    keySet.add(oils[i][j]);
                }
            }
            
            int sum = 0;
            for(int key: keySet) {
                sum += map.get(key);
            }
            results.add(sum);
        }
        
        return Collections.max(results);
    }
}