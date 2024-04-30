import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int node;
		int data;

		public Node(int node, int data) {
			this.node = node;
			this.data = data;
		}
	}
	
	static List<Node> graph[];
	static int n, m, t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			graph = new List[n + 1];
			for (int i = 0; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}

			// 양방향 그래프 연결
			int ghData = 0;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				if((g == x && h == y) || (g == y && h == x)) {
					d = d * 2 - 1;
				} else {
					d *= 2;
				}

				graph[x].add(new Node(y, d));
				graph[y].add(new Node(x, d));
			}

			// 최단 거리 구하기
			int dist[] = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				dist[i] = Integer.MAX_VALUE;
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
				return Integer.compare(a.data, b.data);
			});
			pq.offer(new Node(s, 0));
			dist[s] = 0;

			boolean nodeVisited[] = new boolean[n + 1];

			while (!pq.isEmpty()) {
				Node curNode = pq.poll();

				if (nodeVisited[curNode.node])
					continue;

				nodeVisited[curNode.node] = true;

				for (Node nextNode : graph[curNode.node]) {
					if (dist[nextNode.node] > dist[curNode.node] + nextNode.data) {
						dist[nextNode.node] = dist[curNode.node] + nextNode.data;
						pq.offer(new Node(nextNode.node, dist[nextNode.node]));
					}
				}
			}
			
			List<Integer> ends = new ArrayList<>();
			for (int i = 0; i < t; i++) {
				ends.add(Integer.parseInt(br.readLine()));
			}
			
			PriorityQueue<Integer> results = new PriorityQueue<>();
			for(int end: ends) {
				if(dist[end] == Integer.MAX_VALUE)
					continue;
				
				if(dist[end] % 2 == 1) {
					results.offer(end);
				}
			}
			
			while(!results.isEmpty()) {
				sb.append(results.poll() + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}