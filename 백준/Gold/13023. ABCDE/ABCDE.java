import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> graph[];
	static boolean find = false;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new List[N];
		for(int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x].add(y);
			graph[y].add(x);
		}
		
		// 0 -> 1, 1 -> 2, ..., N-1 -> N으로 이어지는지 확인
		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			if(dfs(i, 0)) {
				find = true;
				break;
			}
		}
		
		
		System.out.println(find ? 1 : 0);
	}
	
	static boolean dfs(int start, int cnt) {
		if(cnt == 4)
			return true;
		
		for(int next: graph[start]) {
			if(!visited[next]) {
				visited[next] = true;
				if(dfs(next, cnt + 1))
					return true;
				visited[next] = false;
			}
		}
		
		return false;
	}
}