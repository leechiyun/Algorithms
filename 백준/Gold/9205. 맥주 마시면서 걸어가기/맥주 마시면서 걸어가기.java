import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int calculateDistance(Node node) {
			return Math.abs(this.x - node.x) + Math.abs(this.y - node.y);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		start: for(int tc= 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());	// 편의점의 수
			
			// 0: 출발지, N-1: 도착지, 나머지는 편의점
			Node nodes[] = new Node[N + 2];
			for(int i = 0; i < nodes.length; i++) {
				st = new StringTokenizer(br.readLine());
				nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			// 플로이드 워샬로 모든 최단 거리를 구해보자
			// N = 100 => O(N^3) = 1,000,000
			int arr[][] = new int[N+2][N+2];
			for(int i = 0; i < N + 2; i++) {
				for(int j = 0; j < N + 2; j++) {
					arr[i][j] = nodes[i].calculateDistance(nodes[j]);
				}
			}
			
//			for(int k = 0; k < N + 2; k++) {
//				for(int i = 0; i < N + 2; i++) {
//					for(int j = 0; j < N + 2; j++) {
//						arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
//					}
//				}
//			}
			
//			sb = new StringBuilder();
//			for(int i = 0; i < arr.length; i++) {
//				for(int j = 0; j < arr[i].length; j++) {
//					sb.append(arr[i][j] + " ");
//				}
//				sb.append("\n");
//			}
			
			// BFS로 방문처리?
			Queue<Integer> queue = new ArrayDeque<>();
			boolean visited[] = new boolean[N + 2];
			queue.offer(0);
			visited[0] = true;
			
			while(!queue.isEmpty()) {
				int curNode = queue.poll();
				
				// 도착지점
				if(curNode == N + 1) {
					sb.append("happy\n");
					
					continue start;
				}
				
				for(int next = 0; next < N + 2; next++) {
					if(!visited[next] && next != curNode && arr[curNode][next] <= 1000) {
						queue.offer(next);
						visited[next] = true;
					}
				}
			}
			
			sb.append("sad\n");
		}
		System.out.println(sb);
	}
}