import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<Node> graph[];
	
	static int dx[] = {-1, 0, 0, 1};
	static int dy[] = {0, -1, 1, 0};
	
	static class Node{
		int node;
		int data;
		
		public Node(int node, int data) {
			this.node = node;
			this.data = data;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int tc = 1;
		while(N != 0) {
			graph = new List[N * N];
			for(int i = 0; i < N*N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			int map[][] = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());	
				}
			}
			
			// 그래프 생성
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					for(int k = 0; k <dx.length; k++) {
						int nextX = i + dx[k];
						int nextY = j + dy[k];
						
						if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
							graph[N * i + j].add(new Node(N * nextX + nextY, map[nextX][nextY])); 
						}
					}
				}
			}
			
			// 다익스트라 구현
			int dist[] = new int[N*N];
			for(int i = 0; i < N*N; i++) {
				dist[i] = Integer.MAX_VALUE;
			}
			
			PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> {
				return Integer.compare(a.data, b.data);
			});
			queue.offer(new Node(0, map[0][0]));
			dist[0] = map[0][0];
			while(!queue.isEmpty()) {
				Node curNode = queue.poll();
				
				if(curNode.data > dist[curNode.node])
					continue;
				
				for(Node next: graph[curNode.node]) {
					if(dist[next.node] > dist[curNode.node] + next.data) {
						dist[next.node] = dist[curNode.node] + next.data;
						
						queue.offer(new Node(next.node, dist[next.node]));
					}
				}
			}
			
			sb.append("Problem " + tc + ": " + dist[N*N -1] + "\n");
			N = Integer.parseInt(br.readLine());
			tc++;
		}
		System.out.println(sb);
	}

}