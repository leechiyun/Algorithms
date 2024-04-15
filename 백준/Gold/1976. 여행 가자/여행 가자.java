import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class UnionFind {
		int parents[];
		
		public UnionFind(int size) {
			parents = new int[size + 1];
			for(int i = 0; i < size + 1; i++) {
				parents[i] = i;
			}
		}
		
		public int find(int x) {
			if(parents[x] == x) 
				return x;
			
			return parents[x] = find(parents[x]);
		}
		
		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			
			if(rootX >= rootY) {
				parents[rootX] = rootY;
			} else {
				parents[rootY] = rootX;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		UnionFind uf = new UnionFind(N);
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				
				if(input == 1) {
					if(uf.find(i) != uf.find(j)) {
						uf.union(i, j);
					}
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int num = uf.find(Integer.parseInt(st.nextToken()) - 1);
		for(int i = 1; i < M; i++) {
			int input = Integer.parseInt(st.nextToken()) - 1;
			if(num != uf.find(input)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}