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
	static int N;

	static int[] 가로 = { 0, 1 };
	static int[] 대각선 = { 1, 1 };
	static int[] 세로 = { 1, 0 };

	static int[][][] directions = { { 가로, 대각선 }, { 가로, 대각선, 세로 }, { 대각선, 세로 } };

	static class Node {
		int x, y;
		// 0: 가로, 1: 대각선, 2:세로
		int state;

		public Node(int x, int y, int state) {
			this.x = x;
			this.y = y;
			this.state = state;
		}

		public List<Integer> nextStates() {
			List<Integer> states = new ArrayList<>();

			if (this.state == 0) {
				states.add(0);
				states.add(1);
			} else if (this.state == 1) {
				states.add(0);
				states.add(1);
				states.add(2);
			} else if (this.state == 2) {
				states.add(1);
				states.add(2);
			}

			return states;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", state=" + state + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(map[N-1][N-1] == 1) {
			System.out.println(0);
			return;
		}

		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(0, 1, 0));

		int result = 0;
		while (!queue.isEmpty()) {
			Node curNode = queue.poll();
			
			if(curNode.x == N-1 && curNode.y == N-1) {
				result++;
				continue;
			}

			List<Integer> nextStates = curNode.nextStates();
			for (int nextState : nextStates) {
				// 대각선의 경우
				if (nextState == 1) {
					// 대각선은 3곳을 전부 확인해야함
					int checkDirections[][] = directions[1];

					boolean flag = true;
					for (int[] checkDirection : checkDirections) {
						int nextX = curNode.x + checkDirection[0];
						int nextY = curNode.y + checkDirection[1];

						if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || map[nextX][nextY] == 1) {
							flag = false;
							break;
						}
					}

					if (flag) {
						queue.offer(new Node(curNode.x + 대각선[0], curNode.y + 대각선[1], nextState));
					}

				} else if(nextState == 2) {
					int nextX = curNode.x + 세로[0];
					int nextY = curNode.y + 세로[1];

					if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && map[nextX][nextY] == 0) {
						queue.offer(new Node(nextX, nextY, nextState));
					}
				} else if(nextState == 0) {
					int nextX = curNode.x + 가로[0];
					int nextY = curNode.y + 가로[1];

					if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && map[nextX][nextY] == 0) {
						queue.offer(new Node(nextX, nextY, nextState));
					}
				}

			}
		}
		System.out.println(result);
	}
}