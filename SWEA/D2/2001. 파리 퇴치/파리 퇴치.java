
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalInt;
import java.util.StringTokenizer;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Solution {
	static int N;
	static int M;
	static int arr[][];
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// 함수 생성
			arr = new int[N][N];
			for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			List<Integer> results = new ArrayList<>();
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					results.add(AttackCount(i, j));
				}
			}
			
			sb.append("#").append(tc).append(" ");
			sb.append(Collections.max(results)).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	public static int AttackCount(int x, int y) {
		int count = 0;
		for (int i = x; i < x + M; i++) {
			for (int j = y; j < y + M; j++) {
				count += arr[i][j];
			}
		}
		return count;
	}

}
