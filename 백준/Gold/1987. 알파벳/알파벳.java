import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean visited[][];
	static char map[][];
	static int result = 0;

	static Map<Character, Boolean> saved = new HashMap<>();

	// 상, 하, 좌, 우 : 이동
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static class Node {
		int x, y;
		char c;

		public Node(int x, int y, char c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M];

		// map 입력
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		// BFS로 구현
		/*
		 * Queue<Node> queue = new ArrayDeque<>(); queue.offer(new Node(0, 0,
		 * map[0][0])); visited[0][0] = true; saved.put(map[0][0], true); int result =
		 * 0; while (!queue.isEmpty()) { Node curNode = queue.poll();
		 * 
		 * for (int i = 0; i < dx.length; i++) { int nextX = curNode.x + dx[i]; int
		 * nextY = curNode.y + dy[i];
		 * 
		 * if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M &&
		 * !visited[nextX][nextY] && !saved.getOrDefault(map[nextX][nextY], false)) {
		 * visited[nextX][nextY] = true; result++; saved.put(map[nextX][nextY], true);
		 * queue.offer(new Node(nextX, nextY, map[nextX][nextY]));
		 * saved.put(map[nextX][nextY], false); } } }
		 * 
		 * System.out.println(result);
		 */

		saved.put(map[0][0], true);
		DFS(0, 0, 1);

		System.out.println(result);
	}

	static void DFS(int x, int y, int count) {
		if (result < count) {
			result = count;
		}

		// 상하좌우로 이동
		for (int i = 0; i < dx.length; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY]
					&& !saved.getOrDefault(map[nextX][nextY], false)) {
				visited[nextX][nextY] = true;
				saved.put(map[nextX][nextY], true);
				DFS(nextX, nextY, count + 1);
				visited[nextX][nextY] = false;
				saved.put(map[nextX][nextY], false);
			}
		}
	}
}