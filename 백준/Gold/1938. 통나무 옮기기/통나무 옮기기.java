import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Train {
		List<Pos> poss = new ArrayList<>();
		int cnt = 0;
		Pos center;
		boolean row = false, col = false;	// 가로
		
		public Train(List<Pos> poss) {
			this.poss = poss;
			
			int maxX = 0;
			int maxY = 0;
			for(Pos p: poss) {
				maxX += p.x;
				maxY += p.y;
			}
			
			center = new Pos(maxX / 3, maxY / 3);
			for(Pos p: poss) {
				if(p.x == center.x && p.y != center.y) {
					row = true;
				}
				if(p.x != center.x && p.y == center.y) {
					col = true;
				}
			}
		}
		
		public Train(List<Pos> poss, int cnt) {
			this.poss = poss;
			this.cnt = cnt;
			
			int maxX = 0;
			int maxY = 0;
			for(Pos p: poss) {
				maxX += p.x;
				maxY += p.y;
			}
			
			center = new Pos(maxX / 3, maxY / 3);
			for(Pos p: poss) {
				if(p.x == center.x && p.y != center.y) {
					row = true;
				}
				if(p.x != center.x && p.y == center.y) {
					col = true;
				}
			}
		}
		
		public boolean checkSame(List<Pos> others) {
			int cnt = 0;
			
			for(Pos pos: poss) {
				for(Pos other: others) {
					if(other.x == pos.x && other.y == pos.y) {
						cnt++;
					}
				}
			}
			
			if(cnt == poss.size())
				return true;
			return false;
		}
		
		public boolean checkRotation(char[][] map, boolean visited[][][]) {
			int dx[] = {-1, 1, 0, 0, -1, 1, -1, 1};
			int dy[] = {0, 0, -1, 1, -1, -1, 1, 1};
			
			int visitedCnt = 0;
			for(int d = 0; d < dx.length; d++) {
				int nextX = center.x + dx[d];
				int nextY = center.y + dy[d];
				
				if(nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map.length) {
					return false;
				}
				
				if(map[nextX][nextY] == '1')
					return false;
			}
			
			int cnt = 0;
			if(row) {
				if(visited[1][center.x][center.y]) {
					cnt++;
				}
				if(visited[1][center.x + 1][center.y]) {
					cnt++;
				}
				if(visited[1][center.x - 1][center.y]) {
					cnt++;
				}
			} else {
				if(visited[0][center.x][center.y]) {
					cnt++;
				}
				if(visited[0][center.x][center.y + 1]) {
					cnt++;
				}
				if(visited[0][center.x][center.y - 1]) {
					cnt++;
				}
			}
			if(cnt == 3) {
				return false;
			}
			
			return true;
		}
	}

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
		
		
	}
	
	static char map[][];
	static int N;
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		List<Pos> starts = new ArrayList<>();
		List<Pos> ends = new ArrayList<>();
		map = new char[N][N];
		int cntX = 0;
		int cntY = 0;
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			
			for(int j = 0; j < N; j++) {
				char c = input.charAt(j);
				
				if(c == 'B') {
					cntX += i;
					cntY += j;
					
					starts.add(new Pos(i, j));
				}
				if(c == 'E') {
					ends.add(new Pos(i, j));
				}
				map[i][j] = c; 
			}
		}
		
		boolean visited[][][] = new boolean[2][N][N];
		Queue<Train> queue = new ArrayDeque<>();
		Train startTrain = new Train(starts);
		queue.offer(startTrain);
		for(Pos start: starts) {
			if(startTrain.row) {
				visited[0][start.x][start.y] = true;
			}else {
				visited[1][start.x][start.y] = true;
			}
			
		}
		
		while(!queue.isEmpty()) {
			Train cur = queue.poll();
			int check = 1;
			if(cur.row) {
				check = 0;
			}
			
			if(cur.checkSame(ends)) {
				System.out.println(cur.cnt);
				return;
			}
			
			out: for(int d = 0; d < dx.length; d++) {
				List<Pos> nexts = new ArrayList<>();
				
				for(Pos pos: cur.poss) {
					nexts.add(new Pos(pos.x + dx[d], pos.y + dy[d]));
				}
				
				int visitCnt = 0;
				for(Pos next: nexts) {
					if(next.x < 0 || next.x >= N || next.y < 0 || next.y >= N) {
						continue out;
					}
					
					if(visited[check][next.x][next.y]) {
						visitCnt++;
					}
					
					if(map[next.x][next.y] == '1') {
						continue out;
					}
				}
				
				if(visitCnt == 3) {
					continue;
				}
				
				for(Pos next: nexts) {
					visited[check][next.x][next.y] = true;
				}
				queue.offer(new Train(nexts, cur.cnt + 1));
			}
			
			// 회전 확인
			if(cur.checkRotation(map, visited)) {
				List<Pos> nexts = new ArrayList<>();
				// 가로인 경우
				if(cur.row) {
					nexts.add(new Pos(cur.center.x, cur.center.y));
					nexts.add(new Pos(cur.center.x -1, cur.center.y));
					nexts.add(new Pos(cur.center.x + 1, cur.center.y));
				}
				else {
					nexts.add(new Pos(cur.center.x, cur.center.y));
					nexts.add(new Pos(cur.center.x, cur.center.y - 1));
					nexts.add(new Pos(cur.center.x, cur.center.y + 1));
				}
				
				Train nextTrain = new Train(nexts, cur.cnt + 1);
				for(Pos next: nexts) {
					if(nextTrain.row) {
						visited[0][next.x][next.y] = true;
					}else {
						visited[1][next.x][next.y] = true;
					}
				}
				
				queue.offer(nextTrain);
			}
		}
		
		System.out.println(0);
	}

}