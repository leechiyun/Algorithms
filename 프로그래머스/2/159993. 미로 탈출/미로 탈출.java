import java.util.*;

class Solution {
    static boolean visitedL[][];
    static boolean visitedM[][];
    static int N;
    static int M;
    
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    
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
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        visitedL = new boolean[N][M];
        visitedM = new boolean[N][M];
        
        // 시작 지점 찾기
        int startX = 0;
        int startY = 0;
        boolean startFlag = false;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(maps[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                    startFlag = true;
                }
            }
            if(startFlag) {
                break;
            }
        }
        
        // 레버 찾기
        List<Node> resultL = new ArrayList<>();
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(startX, startY, 0));
        while(!queue.isEmpty()) {
            Node curNode = queue.poll();
            
            if(maps[curNode.x].charAt(curNode.y) == 'L') {
                resultL.add(new Node(curNode.x, curNode.y, curNode.count));
            }
            
            for(int i = 0; i < dx.length; i++) {
                int nextX = curNode.x + dx[i];
                int nextY = curNode.y + dy[i];
                
                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && 
                   !visitedL[nextX][nextY] && maps[nextX].charAt(nextY) != 'X') {
                    queue.offer(new Node(nextX, nextY, curNode.count + 1));
                    visitedL[nextX][nextY] = true;
                }
            }
        }
        
        // 레버를 찾지 못한 경우, return -1
        if(resultL.isEmpty()) {
            return -1;
        }
        
        // 출구 찾기
        Node minNode = Collections.min(resultL, (a, b) -> a.count - b.count);
        System.out.println(minNode.count);
        List<Integer> results = new ArrayList<>();
        
        queue = new ArrayDeque<>();
        queue.offer(new Node(minNode.x, minNode.y, minNode.count));
        while(!queue.isEmpty()) {
            Node curNode = queue.poll();
            
            if(maps[curNode.x].charAt(curNode.y) == 'E') {
                results.add(curNode.count);
            }
            
            for(int i = 0; i < dx.length; i++) {
                int nextX = curNode.x + dx[i];
                int nextY = curNode.y + dy[i];
                
                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && 
                   !visitedM[nextX][nextY] && maps[nextX].charAt(nextY) != 'X') {
                    queue.offer(new Node(nextX, nextY, curNode.count + 1));
                    visitedM[nextX][nextY] = true;
                }
            }
        }
        
        if(results.isEmpty()) {
            return -1;
        }

        return Collections.min(results);
    }
}