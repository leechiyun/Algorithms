import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int players[];
	static int playerPoint[][];
	static int map[];
	static int max = Integer.MIN_VALUE;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		playerPoint = new int[N][10];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 9; j++) {
				playerPoint[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 멤버 순서 뽑기
		players = new int[9];
		players[3] = 1; // 1번 타자를 항상 4번에 넣는다.

		dfs(new boolean[10], 0);
		
		System.out.println(max);
	}

	static void dfs(boolean visited[], int cnt) {
		if (cnt == 9) {
			// 야구게임 시작
			int playerNum = 0;
			int winPoint = 0;
			
			for(int i = 0; i < N; i++) {
				int outCount = 0;
				map = new int[4];
				
				// 아웃이 될때까지 경기 진행
				while(outCount < 3) {
					int hit = playerPoint[i][players[playerNum % 9]];
					if(hit == 0) {
						outCount++;
					} else {
						winPoint += hitBall(hit);
					}
					
					playerNum++;
				}
			}

			if(max < winPoint) {
				max = winPoint;
			}

			return;
		}

		if(cnt == 3) {
			dfs(visited, cnt + 1);
		}

		// 1번 타자는 이미 위치를 정함
		for (int i = 2; i <= 9; i++) {
			if (!visited[i] && cnt != 3) {
				visited[i] = true;
				players[cnt] = i;
				dfs(visited, cnt + 1);
				visited[i] = false;
			}
		}
	}
	
	static int hitBall(int hit) {
		int winCount = 0;
		
		int newMap[] = new int[4];
		map[0] = 1;
		for(int i = 0; i < map.length; i++) {
			if(map[i] == 0) {
				continue;
			}
			
			if(i + hit < 4) {
				newMap[i + hit] = map[i];
			} else {
				winCount += map[i];
			}
		}
		map = newMap;
		
		return winCount;
	}
}