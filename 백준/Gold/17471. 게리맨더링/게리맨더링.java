import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int persons[];
	static List<Integer> graphs[];
	static int choosed[];
	static int N;

	static Set<Integer> results = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		persons = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			persons[i] = Integer.parseInt(st.nextToken());
		}

		graphs = new List[N + 1];
		choosed = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			graphs[i] = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				graphs[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		dfs(0);
		
		if(results.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(Collections.min(results));
		}
	}

	// 부분 집합으로 지역을 뽑는다
	static void dfs(int cnt) {
		if (cnt == N) {
			// 1 ~ N: 선택된 지역이 연결되어 있는지 확인
			boolean visited[] = new boolean[N + 1];
			
			int groupCnt = 0;
			for(int i = 1; i <= N; i++) {
				// 탐색
				if(!visited[i]) {
					int countryNum = choosed[i];
					
					// BFS 탐색
					Queue<Integer> queue = new ArrayDeque<>();
					queue.offer(i);
					visited[i] = true;
					while(!queue.isEmpty()) {
						int cur = queue.poll();
						
						for(int next: graphs[cur]) {
							if(!visited[next] && choosed[next] == countryNum) {
								visited[next] = true;
								queue.offer(next);
							}
						}
					}
					
					groupCnt++;
				}
			}
			
			// 2개로 잘 연결됨
			if(groupCnt == 2) {
				int country1 = 0;
				int country2 = 0;
				
				for(int i = 1; i <= N; i++) {
					if(choosed[i] == 1) {
						country1 += persons[i];
					} else if(choosed[i] == 2) {
						country2 += persons[i];
					}
				}
				
				results.add(Math.abs(country1 - country2));
			}

			return;
		}

		choosed[cnt + 1] = 1;
		dfs(cnt + 1);
		choosed[cnt + 1] = 2;
		dfs(cnt + 1);
	}
}