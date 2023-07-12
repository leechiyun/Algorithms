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
		
		int result[] = new int[N+1];
		for(int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int num = Integer.parseInt(str[2]);
			
			for(int j=x-1; j<y; j++) {
				result[j] = num;
			}
		}
		
		String answer = "";
		for(int i=0; i<N; i++) {
			answer += result[i] + " ";
		}
		
		System.out.println(answer.substring(0, answer.length()-1));
	}
}