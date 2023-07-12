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
		
		// 선언 및 초기화
		int result[] = new int[N];
		for(int i=1; i<=N; i++) {
			result[i-1] = i;
		}
		
		for(int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			
			// 서로 바꾸기
			int temp = result[x-1];
			result[x-1] = result[y-1];
			result[y-1] = temp;
		}
		
		String answer = "";
		for(int i=0; i<N; i++) {
			answer += result[i] + " ";
		}
		
		System.out.println(answer.substring(0, answer.length()-1));
	}
}