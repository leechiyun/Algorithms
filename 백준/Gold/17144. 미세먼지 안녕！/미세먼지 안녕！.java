import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, T;
	static int map[][];

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static class Aircon {
		Node up;
		Node down;

		public Aircon(Node up, Node down) {
			this.up = up;
			this.down = down;
		}

		public boolean containNode(int x, int y) {
			return (up.x == x && up.y == y) || (down.x == x && down.y == y);
		}

		@Override
		public String toString() {
			return "Aircon [up=" + up + ", down=" + down + "]";
		}
	}

	static class Node {
		int x, y;
		int count;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			this.count = 0;
		}

		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		List<Node> airconPos = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());

				if (input == -1) {
					airconPos.add(new Node(i, j));
				}

				map[i][j] = input;
			}
		}

		Aircon aircon = new Aircon(airconPos.get(0), airconPos.get(1));

		// 시뮬레이션
		for (int t = 1; t <= T; t++) {
			// 1. 미세먼지 확산
			// 초기 미세먼지 Node들
			Queue<Node> queue = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > 0) {
						queue.offer(new Node(i, j, map[i][j]));
					}
				}
			}

			while (!queue.isEmpty()) {
				Node curNode = queue.poll();

				// 4방향으로 확산
				for (int d = 0; d < dx.length; d++) {
					int nextX = curNode.x + dx[d];
					int nextY = curNode.y + dy[d];

					if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && map[nextX][nextY] != -1) {
						map[nextX][nextY] += curNode.count / 5;
						map[curNode.x][curNode.y] -= curNode.count / 5;
					}
				}
			}

			// 2. 공기청정기 작동
			int newMap[][] = copyMap(map);
			boolean visited[][] = new boolean[N][M];

			// 위쪽 에어컨 반시계 방향
			int xs[] = { 0, -1, 0, 1 };
			int ys[] = { 1, 0, -1, 0 };

			int curIdx = 0;
			int nextIdx = 0;
			int curX = aircon.up.x;
			int curY = aircon.up.y;
			int nextX = aircon.up.x + xs[nextIdx];
			int nextY = aircon.up.y + ys[nextIdx];

			visited[curX][curY] = true;
			map[nextX][nextY] = 0;

			while (!visited[nextX][nextY]) {
				curX += xs[curIdx];
				curY += ys[curIdx];
				nextX += xs[nextIdx];
				nextY += ys[nextIdx];

				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
					nextX -= xs[nextIdx];
					nextY -= ys[nextIdx];
					nextIdx++;
					nextX += xs[nextIdx];
					nextY += ys[nextIdx];
				}
				if (curX < 0 || curX >= N || curY < 0 || curY >= M) {
					curX -= xs[curIdx];
					curY -= ys[curIdx];
					curIdx++;
					curX += xs[curIdx];
					curY += ys[curIdx];
				}

				visited[curX][curY] = true;
				map[nextX][nextY] = newMap[curX][curY];
			}
			map[aircon.up.x][aircon.up.y] = -1;

			// 위쪽 에어컨 반시계 방향
			xs = new int[]{ 0, 1, 0, -1 };
			ys = new int[]{ 1, 0, -1, 0 };

			curIdx = 0;
			nextIdx = 0;
			curX = aircon.down.x;
			curY = aircon.down.y;
			nextX = aircon.down.x + xs[nextIdx];
			nextY = aircon.down.y + ys[nextIdx];

			visited[curX][curY] = true;
			map[nextX][nextY] = 0;

			while (!visited[nextX][nextY]) {
				curX += xs[curIdx];
				curY += ys[curIdx];
				nextX += xs[nextIdx];
				nextY += ys[nextIdx];

				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
					nextX -= xs[nextIdx];
					nextY -= ys[nextIdx];
					nextIdx++;
					nextX += xs[nextIdx];
					nextY += ys[nextIdx];
				}
				if (curX < 0 || curX >= N || curY < 0 || curY >= M) {
					curX -= xs[curIdx];
					curY -= ys[curIdx];
					curIdx++;
					curX += xs[curIdx];
					curY += ys[curIdx];
				}

				visited[curX][curY] = true;
				map[nextX][nextY] = newMap[curX][curY];
			}
			map[aircon.down.x][aircon.down.y] = -1;
		}

		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] > 0) {
					result += map[i][j];
				}
			}
		}
		
		System.out.println(result);
	}

	private static int[][] copyMap(int map[][]) {
		int newMap[][] = new int[map.length][map[0].length];

		for (int i = 0; i < map.length; i++) {
			newMap[i] = Arrays.copyOf(map[i], map[i].length);
		}
		return newMap;
	}

	private static void printMap(int map[][]) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}