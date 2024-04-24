import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> graphs[]; // 무방향 그래프
	static int N, M;
	static int S;
	static List<Integer> fans;

	static class Node {
		int num;
		boolean meet;

		public Node(int num) {
			this.num = num;
			this.meet = false;
		}

		public Node(int num, boolean meet) {
			this.num = num;
			this.meet = meet;
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", meet=" + meet + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graphs = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			graphs[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graphs[x].add(y);
		}

		S = Integer.parseInt(br.readLine());
		fans = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; i++) {
			fans.add(Integer.parseInt(st.nextToken()));
		}

		Queue<Node> queue = new ArrayDeque<>();
		if (fans.contains(1)) {
			queue.offer(new Node(1, true));
		} else {
			queue.offer(new Node(1, false));
		}

		while (!queue.isEmpty()) {
			Node curNode = queue.poll();

			// 끝 점
			if (graphs[curNode.num].isEmpty()) {
				if (!curNode.meet) {
					System.out.println("yes");
					return;
				}
			}

			for (int next : graphs[curNode.num]) {
				if (!fans.contains(next)) {
					queue.offer(new Node(next, curNode.meet));
				}
			}
		}

		System.out.println("Yes");
	}
}