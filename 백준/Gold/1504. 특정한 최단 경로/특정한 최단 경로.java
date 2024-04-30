import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

		@Override
		public String toString() {
			return "Node [node=" + node + ", data=" + data + "]";
		}
		
	}
	
	static boolean nodeVisited[];
	static boolean edgeVisited[][];
	
	static List<Node> graph[];
	
	static int dist[];
	
	static int N, M;
	
	static PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
		return Integer.compare(a.data, b.data);
	});
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 1. 그래프 입출력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nodeVisited = new boolean[N+1];
		edgeVisited = new boolean[N+1][N+1];
		
		graph = new List[N + 1];
		dist = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		
		// 반드시 방문해야 할 정점 2개
		st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());

		// 두가지 경우의 수
		// 1. 1 -> p1 -> p2 -> N
		// 2. 1 -> p2 -> p1 -> N
		Long result1 = dijk(1, p1) + dijk(p1, p2) + dijk(p2, N);
		Long result2 = dijk(1, p2) + dijk(p2, p1) + dijk(p1, N);
		
		Long result = Math.min(result1, result2);
		
		System.out.println(result >= Integer.MAX_VALUE? -1: result);
	}
	
	static Long dijk(int start, int end) {
		dist = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		nodeVisited = new boolean[N+1];
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			
			if(nodeVisited[curNode.node])
				continue;
			
			nodeVisited[curNode.node] = true;
			
			for(Node nextNode:graph[curNode.node]) {
				if(dist[nextNode.node] > dist[curNode.node] + nextNode.data) {
					dist[nextNode.node] = dist[curNode.node] + nextNode.data;
					pq.offer(new Node(nextNode.node, dist[nextNode.node]));
				}
			}
		}
		
		return (long)dist[end];
	}
}