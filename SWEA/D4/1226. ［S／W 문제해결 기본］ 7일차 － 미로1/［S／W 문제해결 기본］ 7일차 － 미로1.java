import java.util.Scanner;
import java.io.*;
import java.util.*;

class Solution
{
    // 상, 하, 좌, 우
    static int dx[] = {-1, 0, 0, 1};
    static int dy[] = {0, -1, 1, 0};
    
    static int map[][];
    static boolean visited[][];
    public static class Node {
    	int x, y;
        
        Node(int x, int y) {
        	this.x = x;
            this.y = y;
        }
    }
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		for(int tc = 1; tc <= 10; tc++) {
        	int testCase = Integer.parseInt(br.readLine());
            
            int N = 16;
            map = new int[N][N];
            visited = new boolean[N][N];
            
            // map 생성
            Node startNode = new Node(0, 0);
            Node endNode = new Node(0, 0);
            for(int i = 0; i < N; i++) {
            	String str = br.readLine();
                for(int j = 0; j < N; j++) {
                    int num = Character.getNumericValue(str.charAt(j));
                    map[i][j] = num;
                    
                    if(num == 2) {
                    	startNode.x = i;
                        startNode.y = j;
                    }
                    if(num == 3) {
                        endNode.x = i;
                        endNode.y = j;
                    }
                }
            }
            
            Queue<Node> queue = new ArrayDeque<>();
            queue.offer(startNode);
            // 첫 시작점 방문 처리
            visited[startNode.x][startNode.y] = true;
            
            boolean flag = false;
            while(!queue.isEmpty()){
            	Node curNode = queue.poll();
                
                // 미로 도착
                if(curNode.x == endNode.x && curNode.y == endNode.y) {
                	flag = true;
                }
                
                for(int i = 0; i < dx.length; i++){
                	int nextX = curNode.x + dx[i];
                    int nextY = curNode.y + dy[i];
                    
                    if(nextX >= 0 && nextX <N && nextY >= 0 && nextY < N && map[nextX][nextY] != 1 && !visited[nextX][nextY] ) {
                    	queue.offer(new Node(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }
            
            System.out.println("#" + tc + " " + (flag?1:0));
        }
	}
}