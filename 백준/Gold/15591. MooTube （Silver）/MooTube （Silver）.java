import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, Q;
	static int map[][];
	static List<Integer> graph[];
	static boolean visited[];
	static int find;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		graph = new List[N + 1];
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		map = new int[N + 1][N + 1];
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			map[x][y] = r;
			map[y][x] = r;
			
			graph[x].add(y);
			graph[y].add(x);
		}
		
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			int result = 0;
			Queue<Integer> queue = new ArrayDeque<>();
			queue.offer(v);
			boolean visited[] = new boolean[N + 1];
			visited[v] = true;
			int min = Integer.MAX_VALUE;
			
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				
				for(int next: graph[cur]) {
					if(!visited[next] && map[cur][next] >= k) {
						result++;
						visited[next] = true;
						queue.offer(next);
						min = Math.min(min, map[cur][next]);
					}
				}
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
	
}