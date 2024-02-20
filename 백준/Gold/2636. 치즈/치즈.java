import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static int N, M;

	// 8방 탐색
	static int dx[] = { 1, 0, 0, -1 };
	static int dy[] = { 0, 1, -1, 0 };

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		int totalCheeze = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1) {
					totalCheeze++;
				}
			}
		}

		int time = 0;
		List<Integer> cheesCounts = new ArrayList<>();
		while (true) {
			// 남아있는 치즈 갯수 세기
			boolean removeMap[][] = new boolean[N][M];
			// map 탐방하며 공기와 닿은면 제거

			// 공기 끼리의 위치만 찾고 치즈가 닿은 부분을 구함
			boolean[][] visited = new boolean[N][M];

			Queue<Pos> queue = new ArrayDeque<>();
			queue.offer(new Pos(0, 0));
			visited[0][0] = true;
			while (!queue.isEmpty()) {
				Pos curPos = queue.poll();

				for (int i = 0; i < dx.length; i++) {
					int nextX = curPos.x + dx[i];
					int nextY = curPos.y + dy[i];

					if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY]) {
						if (map[nextX][nextY] == 1) {
							removeMap[nextX][nextY] = true;
						}

						if (map[nextX][nextY] == 0) {
							queue.offer(new Pos(nextX, nextY));
							visited[nextX][nextY] = true;
						}
					}
				}
			}

			cheesCounts.add(totalCheeze);
			time++;

			// 치즈 제거
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (removeMap[i][j]) {
						map[i][j] = 0;
						totalCheeze--;
					}
				}
			}
			if(totalCheeze == 0) {
				break;
			}
		}
		
		System.out.println(time);
		System.out.println(cheesCounts.get(cheesCounts.size() - 1));
	}
}