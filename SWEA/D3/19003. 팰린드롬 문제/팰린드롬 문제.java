import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		// 1. 펠린드롬인 값과 아닌 값의 구분
		// 2. 쌍으로 되는 값을 계산
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 1. 문자열 입력 받기
			List<String> inputs = new ArrayList<>();
			for(int i = 0; i<N; i++) {
				inputs.add(br.readLine());
			}
			
			// 펠린드롬이 아닌 값
			Stack<String> isNotPelindromList = new Stack<>();
			boolean checkPelindrom = false;
			for(String input: inputs) {
				if(isPelindrom(input)) {
					checkPelindrom = true;
				} else {
					isNotPelindromList.add(input);
				}
			}
			
			// 2. 쌍으로 되는 값을 계산
			int count = 0;
			while(!isNotPelindromList.isEmpty()) {
				String str = isNotPelindromList.pop();
				String reverseStr = new StringBuffer(str).reverse().toString();
				
				if(isNotPelindromList.contains(reverseStr)) {
					count += 2;
				}
			}
			
			if(checkPelindrom) {
				count += 1;
			}
			
			System.out.println("#" + tc + " " + count * M);
		}
		
		
	}
	
	static boolean isPelindrom(String input) {
		int start = 0;
		int last = input.length() - 1;
		
		while(start <= last) {
			if(input.charAt(last) != input.charAt(start)) {
				return false;
			}
			
			start++;
			last--;
		}
		
		return true;
	}
}