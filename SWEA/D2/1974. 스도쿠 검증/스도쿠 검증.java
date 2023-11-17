
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static int arr[][];
	
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = 9;
			arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int result = 0;
			if(checkRows() && checkColumns() && checkSquare()) {
				result = 1;
			}
			
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("#").append(tc).append(" ").append(result);
			System.out.println(sBuilder);
		}
	}
	
	public static boolean checkSudokeList(List<Integer> list) {
		if(list.size() != 9) {
			return false;
		}
		
		for(int i=1; i<=N; i++) {
			if(!list.contains(i)) {
				return false;
			}
		}
		
		return true;
	}
	

	public static boolean checkRows() {
		for (int i = 0; i < arr.length; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < arr.length; j++) {
				list.add(arr[i][j]);
			}
			
			if(!checkSudokeList(list)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean checkColumns() {
		for (int i = 0; i < arr.length; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < arr.length; j++) {
				list.add(arr[j][i]);
			}
			
			if(!checkSudokeList(list)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean checkSquare() {
		for (int i = 0; i < arr.length; i+=3) {
			List<Integer> list = new ArrayList<>();
			for(int k = i; k<i+3; k++) {
				for (int l = i; l < i+3; l++) {
					list.add(arr[k][l]);
				}
			}
			
			
			if(!checkSudokeList(list)) {
				return false;
			}
		}
		
		return true;
	}

}
