import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	
	static class Player {
		int num;
		int multi, sum;
		
		public Player(int num, int x, int y, int z) {
			this.num = num;
			multi = x * y * z;
			sum = x + y + z;
		}
	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Player> pq = new PriorityQueue<>((a, b) -> {
			if(a.multi == b.multi) {
				if(a.sum == b.sum) {
					return Integer.compare(a.num, b.num);
				}
				
				return Integer.compare(a.sum, b.sum);
			}
			return Integer.compare(a.multi, b.multi);
		});
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			pq.offer(new Player(num, x, y, z));
		}
		
		Player gold = pq.poll();
		Player silver = pq.poll();
		Player bronze = pq.poll();
		
		System.out.println(gold.num + " " + silver.num + " " + bronze.num);
	}

}