import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> graphs[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		graphs = new List[N + 1];
		for(int i = 0; i <= N; i++) {
			graphs[i] = new ArrayList<>();
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 양방향 그래프
			graphs[x].add(y);
			graphs[y].add(x);
		}
		
		// BFS로 그래프 탐색
		Queue<Integer> queue = new ArrayDeque<>();
		boolean visited[] = new boolean[N + 1];
		
		queue.offer(1);
		visited[1] = true;
		int count = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int next: graphs[cur]) {
				if(!visited[next]) {
					visited[next] = true;
					queue.offer(next);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}