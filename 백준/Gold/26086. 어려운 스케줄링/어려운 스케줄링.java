import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, Q, k;
	static boolean flag = true; // 기본 stack 순서대로 처리

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		ArrayDeque<Integer> leftQueue = new ArrayDeque<>();
		ArrayDeque<Integer> rightQueue = new ArrayDeque<>();
		PriorityQueue<Integer> ascPQ = new PriorityQueue<>(); // 오름 차순
		PriorityQueue<Integer> descPQ = new PriorityQueue<>((a, b) -> {
			return Integer.compare(b, a);
		}); // 내림 차순

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());

			int command = Integer.parseInt(st.nextToken());
			if (command == 0) {
				int input = Integer.parseInt(st.nextToken());
				if(flag) {
					rightQueue.add(input);
				} else {
					leftQueue.addFirst(input);
				}
				
				
			} else if (command == 1) {
				flag = true;
				
				while (!leftQueue.isEmpty()) {
					int pollData = leftQueue.poll();
					ascPQ.offer(pollData);
					descPQ.offer(pollData);
				}
				
				while (!rightQueue.isEmpty()) {
					int pollData = rightQueue.poll();
					ascPQ.offer(pollData);
					descPQ.offer(pollData);
				}
			} else if (command == 2) {
				flag = !flag;
			}
		}
		
		int result = 0;
		for(int i = 0; i < k; i++) {
			if(flag) {
				// right -> PQ -> left
				// pollLast
				if(!rightQueue.isEmpty()) {
					result = rightQueue.pollLast();
				} else if(!ascPQ.isEmpty()) {
					result = ascPQ.poll();
				} else {
					result = leftQueue.pollLast();
				}
			} else {
				// left -> PQ -> Right
				// poll
				if(!leftQueue.isEmpty()) {
					result = leftQueue.poll();
				} else if(!descPQ.isEmpty()) {
					result = descPQ.poll();
				} else {
					result = rightQueue.poll();
				}
			}
		}

		System.out.println(result);
	}
}