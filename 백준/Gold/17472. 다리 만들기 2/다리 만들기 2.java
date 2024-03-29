import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static int N, M;
	static int map[][];
	static int islandCount = 0;
	static List<Island> islands = new ArrayList<>();

	static class Island {
		List<Node> nodes;

		public Island() {
			nodes = new ArrayList<>();
		}

		@Override
		public String toString() {
			return "Island [nodes=" + nodes + "]";
		}

		public boolean contain(int x, int y) {
			for (Node n : this.nodes) {
				if (n.x == x && n.y == y) {
					return true;
				}
			}
			return false;
		}

		public int calculateDistance(Island other) {
			int result = Integer.MAX_VALUE;
			// 가로 세로로 이동 가능
			for (Node node : nodes) {
				
				// node
				for (int d = 0; d < dx.length; d++) {
					int nextX = node.x + dx[d];
					int nextY = node.y + dy[d];
					
					if(this.contain(nextX, nextY)) {
						continue;
					}

					int cnt = 0;
					boolean flag = false;
					while (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
						if(map[nextX][nextY] == 1) {
							if (other.contain(nextX, nextY)) {
								flag = true;
							}
							break;
						}
						
						
						cnt++;
						nextX += dx[d];
						nextY += dy[d];
					}

					if (flag && cnt >= 2) {
						result = Math.min(result, cnt);
					}
				}
			}

			return result;
		}
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
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

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
	}
	
	static class UnionFind {
		int[] parents;
		
		public UnionFind(int size) {
			parents = new int[size];
			
			for(int i = 0; i < parents.length; i++) {
				parents[i] = i;
			}
		}
		
		public int find(int x) {
			if(x == parents[x])
				return x;
			
			return parents[x] = find(parents[x]);
		}
		
		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			
			if(rootX < rootY) {
				parents[rootY] = rootX;
			} else {
				parents[rootX] = rootY;
			}
		}
	}

	// MST로 구현해 보자
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// BFS로 맵을 돌아가며
		boolean visited[][] = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Island island = null;
				if (!visited[i][j] && map[i][j] == 1) {
					// BFS로 island 찾기
					Queue<Node> queue = new ArrayDeque<>();
					queue.offer(new Node(i, j));
					visited[i][j] = true;

					island = new Island();

					while (!queue.isEmpty()) {
						Node curNode = queue.poll();
						island.nodes.add(curNode);

						for (int d = 0; d < dx.length; d++) {
							int nextX = curNode.x + dx[d];
							int nextY = curNode.y + dy[d];

							if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY]
									&& map[nextX][nextY] == 1) {
								queue.offer(new Node(nextX, nextY));
								visited[nextX][nextY] = true;
							}
						}
					}

					if (island != null) {
						islands.add(island);
					}
				}
			}
		}
		
		// MST 알고리즘으로 최소 거리 구하기
		// 1. Edge 만들기
		List<Edge> edges = new ArrayList<>();
		for(int i = 0; i < islands.size(); i++) {
			for(int j = i + 1; j < islands.size(); j++) {
				int distance = islands.get(i).calculateDistance(islands.get(j));
				
				if(distance != Integer.MAX_VALUE) {
					edges.add(new Edge(i, j, distance));
				}
			}
		}
		
		
		// 2. Edge 오름차순 정렬
		Collections.sort(edges, (a, b) -> {
			return Integer.compare(a.weight, b.weight);
		});
		
		UnionFind uf = new UnionFind(islands.size());
		
		// 
		int totalWeight = 0;
		int cnt = 0;
		for(Edge edge: edges) {
			if(uf.find(edge.start) != uf.find(edge.end)) {
				uf.union(edge.start, edge.end);
				totalWeight += edge.weight;
				cnt++;
			}
		}

		if(cnt != islands.size() - 1) {
			System.out.println(-1);
		} else {
			System.out.println(totalWeight == 0 ? -1 : totalWeight);
		}
	}
}