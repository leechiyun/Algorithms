import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class UnionFind {
		int parents[];
		
		public UnionFind(int size) {
			parents = new int[size];
			for(int i = 0; i < size; i++) {
				parents[i] = i;
			}
		}
		
		public int find(int x) {
			if(x == parents[x]) {
				return x;
			}
			
			return parents[x] = find(parents[x]);
		}
		
		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			
			if(rootX >= rootY) {
				parents[rootY] = rootX;
			} else {
				parents[rootX] = rootY;
			}
		}
	}
	
	static class Edge {
		int start, end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	
	static int N, M, t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		UnionFind uf = new UnionFind(N + 1);
		
		PriorityQueue<Edge> edges = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a.weight, b.weight);
		});
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edges.offer(new Edge(start, end, weight));
		}
		
		int cnt = 0;
		int total = 0;
		while(!edges.isEmpty()) {
			Edge curEdge = edges.poll();
			
			if(uf.find(curEdge.start) != uf.find(curEdge.end)) {
				total += curEdge.weight + (cnt * t);
				uf.union(curEdge.start, curEdge.end);
				cnt++;
			}
		}
		
		System.out.println(total);
	}

}