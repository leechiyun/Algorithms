
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Solution {
	static int N;
	static int M;
	static int arr[][];
	static boolean visited[][];
	static int dx[] = new int[] { 0, 1, 0, -1 };
	static int dy[] = new int[] { 1, 0, -1, 0 };
	
	public static class Node {
		int x, y;
		int count;
		
		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < input.length(); j++) {
					arr[i][j] = Character.getNumericValue(input.charAt(j));
				}
			}

			PriorityQueue<Node> queue = new PriorityQueue<>((a, b)-> a.count - b.count);
			queue.offer(new Node(0, 0, 0));
			while (!queue.isEmpty()) {
				Node curNode = queue.poll();
				
				if(curNode.x == N -1 && curNode.y == N -1) {
					System.out.println("#"+tc + " "+ curNode.count);
                    break;
				}
				
				for (int i = 0; i < dx.length; i++) {
					int nextX = curNode.x + dx[i];
					int nextY = curNode.y + dy[i];
					
					if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY]) {
                        visited[nextX][nextY]  = true;
						queue.offer(new Node(nextX, nextY, curNode.count + arr[nextX][nextY]));
					}
				}
				
			}
			
			
		}
	}
	


}
