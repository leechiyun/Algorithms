import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 위상 정렬 문제
public class Main {
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		graph = new List[N + 1];
		for(int i = 0 ; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 단방향 그래프
			graph[x].add(y);
		}
		
		/* 위상 정렬 구현 */
		// 진입 차수 계산
		int[] inputDegrees = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			for(int idx: graph[i]) {
				inputDegrees[idx]++;
			}
		}
		
		// 진입 차수가 0인 지점 넣기
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			if(inputDegrees[i] == 0) {
				queue.offer(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur + " ");
			
			for(int next: graph[cur]) {
				inputDegrees[next]--;
				if(inputDegrees[next] == 0) {
					queue.offer(next);
				}
			}
		}
		
		System.out.println(sb);
	}

}