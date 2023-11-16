
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static int arr[][];
	static boolean visited[][];
	static int dx[] = new int[] { 0, 1 };
	static int dy[] = new int[] { 1, 0 };
	
	public static class Node {
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		for(int tc=1; tc<=T; tc++) {
			int testCase = Integer.parseInt(br.readLine());
			N = 100;
			arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			StringBuilder sb = new StringBuilder();
			for(int start=0; start < N; start++) {
				visited = new boolean[N][N];
				Queue<Node> queue = new ArrayDeque<>();
				boolean flag = false;
				if(arr[0][start] == 1) {
					queue.offer(new Node(0, start));
				}
				
				while (!queue.isEmpty()) {
					Node curNode = queue.poll();
					
					if(arr[curNode.x][curNode.y] == 2) {
						sb.append("#").append(testCase).append(" ").append(start);
						flag = true;
	                    break;
					}
					
					// 오른쪽 방향 확인
					while(curNode.y + 1 < N && arr[curNode.x][curNode.y + 1] == 1 && !visited[curNode.x][curNode.y + 1]) {
						visited[curNode.x][curNode.y + 1] = true;
						curNode.y += 1;
					}
					
					while(curNode.y - 1 >= 0 && arr[curNode.x][curNode.y - 1] == 1  && !visited[curNode.x][curNode.y - 1]) {
						visited[curNode.x][curNode.y - 1] = true;
						curNode.y -= 1;
					}
					
					int nextX = curNode.x + 1;
					int nextY = curNode.y;
					if(nextX < N && !visited[nextX][nextY]) {
						visited[nextX][nextY] = true;
						queue.offer(new Node(nextX, nextY));
					}
					
				}
				
				if(flag) {
					break;
				}
			}	
			
			System.out.println(sb);
		}
	}
	


}
