import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	static Set<String> set;
	static int N = 0, K = 0;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			set = new HashSet<>();
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			// char List 구현
			List<Character> characters = new ArrayList<>();
			String input = br.readLine();
			for(char c: input.toCharArray()) {
				characters.add(c);
			}
			
			extract(characters);
			for(int i = 0; i < N / 4; i++) {
				rotate(characters);
				extract(characters);
			}
			
			// String 형태의 16진수를 10진수로 변환 후 저장
			List<Integer> results = new ArrayList<>();
			for(String str: set) {
				results.add(Integer.parseInt(str, 16));
			}
			Collections.sort(results, (a, b) -> b - a);
			
			System.out.println("#" + tc + " " + results.get(K - 1));
		}
	}
	public static void extract(List<Character> list) {
		int size = N / 4;
		for(int i = 0; i < 4; i++) {
			String str = "";
			
			for(int j = 0; j < size; j++) {
				str += list.get(i * size + j);
			}
			
			set.add(str);
		}
		
	}
	
	public static void rotate(List<Character> list) {
		char temp = list.get(list.size() - 1);
		
		// 마지막 값 삭제
		list.remove(list.size() - 1);
		list.add(0, temp);
	
	}
}