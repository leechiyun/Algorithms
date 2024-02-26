import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static class Mission {
		int score;
		int time;
		
		public Mission(int score, int time) {
			this.score = score;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Mission [score=" + score + ", time=" + time + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int totalScore = 0;
		Stack<Mission> missionStack = new Stack<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int command = Integer.parseInt(st.nextToken());
			
			// 명령 1이 들어가면, 새로운 미션 추가
			if(command == 1) {
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				
				missionStack.push(new Mission(score, time));
			}
			
			if(missionStack.isEmpty())
				continue;
				
			// 미션 시작
			Mission cur = missionStack.pop();
			
			cur.time--;
			
			// 해당 미션을 완료하면, 점수 추가
			if(cur.time == 0)
				totalScore += cur.score;
			else {
				missionStack.push(cur);
			}
			
		}
		
		System.out.println(totalScore);
	}
}