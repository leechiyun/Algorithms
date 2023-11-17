
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static List<String> list = 
			Arrays.asList("0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011");
	
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			
			List<Integer> resultList = new ArrayList<>();
			List<String> inputList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				inputList.add(br.readLine());
			}
			
			for(String input: inputList) {
				boolean flag = false;
				for (int j = 0; j < input.length(); j++) {
					resultList = new ArrayList<>();
					if (j + 7 < input.length() && list.contains(input.substring(j, j+7))) {
						for(int k=0; k < 8; k++) {
							String code = "";
							if(j + (k * 7) + 7 < input.length()) {
								code = input.substring(j + (k * 7), j + (k * 7) + 7);
							}
							
							if(list.contains(code)) {
								resultList.add(list.indexOf(code));
							}
						}
					}
					if(resultList.size() == 8) {
						flag = true;
						break;
					}
				}
				if(flag) {
					break;
				}
			}
			
			int result = 0;
			if(checkCode(resultList)) {
				for(int num: resultList) {
					result += num;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(result);
			System.out.println(sb);
			
		
		}
	}
	
	public static boolean checkCode(List<Integer> list) {
		int oddNumber = 0;
		int evenNumber = 0;
		
		for(int i=0; i<list.size(); i++) {
			// 홀수
			if(i % 2 == 0) {
				oddNumber += list.get(i);
			} else {
				evenNumber += list.get(i);
			}
		}
		
		if((oddNumber * 3 + evenNumber) % 10 == 0) {
			return true;
		}
		return false;
	}

}
