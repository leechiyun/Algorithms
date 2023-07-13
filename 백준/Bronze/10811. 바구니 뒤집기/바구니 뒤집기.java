import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" "); 
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		
		for(int i=0; i<M; i++) {
			String input[] = br.readLine().split(" "); 
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			
			Collections.reverse(list.subList(x-1, y));
		}

		// 결과 출력
		String result = "";
		for(int i=0; i<N; i++) {
			result += list.get(i) + " ";
		}
		result.substring(0, list.size()-1);
		System.out.println(result.substring(0, result.length()-1));
	}
}
