import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int x, y;
		int trashCnt;
		int aroundCnt;
		
		public Node(int x, int y, int trashCnt, int aroundCnt) {
			this.x = x;
			this.y = y;
			this.trashCnt = trashCnt;
			this.aroundCnt = aroundCnt;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", trashCnt=" + trashCnt + ", aroundCnt=" + aroundCnt + "]";
		}
		
		
	}
	
	static int N, M;
	static String map[][];
	
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	
	
	// 만약 어떤 칸이 비어있는데, 인접한 칸에 쓰레기가 있으면 쓰레기 옆을 지나는 것이다. 그리고, S와 F는 세지 않는다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Node startNode = null;
		Node endNode = null;
		
		List<Node> trashs = new ArrayList<>();
		map = new String[N][M];
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				char c = input.charAt(j);
				
				if(c == 'g') {
					trashs.add(new Node(i, j, 0, 0));
				}
				
				if(c == 'S') {
					startNode = new Node(i, j, 0, 0);
				}
				if(c == 'F') {
					endNode = new Node(i, j, 0, 0);
				}
				
				map[i][j] = String.valueOf(c);
			}
		}
		
		// 쓰레기 주변 설정
		for(Node trash: trashs) {
			for(int d = 0; d < dx.length; d++) {
				int nextX = trash.x + dx[d];
				int nextY = trash.y + dy[d];
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					map[nextX][nextY] += 'a';
				}
				
			}
		}
		
//		StringBuilder sb = new StringBuilder();
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				sb.append(map[i][j] + " ");
//			}
//			sb.append("\n");
//		}
//		System.out.println(sb);
		
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
			if(a.trashCnt == b.trashCnt) {
				return Integer.compare(a.aroundCnt, b.aroundCnt);
			}
			return Integer.compare(a.trashCnt, b.trashCnt);
		});
		
		pq.offer(startNode);
		boolean visited[][] = new boolean[N][M];
		visited[startNode.x][startNode.y] = true;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.x == endNode.x && cur.y == endNode.y) {
				System.out.println(cur.trashCnt + " " + cur.aroundCnt);
				return;
			}
			
			for(int d = 0; d < dx.length; d++) {
				int nextX = cur.x + dx[d];
				int nextY = cur.y + dy[d];
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M
						&& !visited[nextX][nextY]) {
					int nextTrashCnt = cur.trashCnt;
					int nextAroundCnt = cur.aroundCnt;
					
					if(map[nextX][nextY].contains("g")) {
						nextTrashCnt++;
					}
					if(map[nextX][nextY].contains(".") && map[nextX][nextY].contains("a")) {
						nextAroundCnt++;
					}
					
					
					pq.offer(new Node(nextX, nextY, nextTrashCnt, nextAroundCnt));
					visited[nextX][nextY] = true;
				}
			}
		}
	}
}