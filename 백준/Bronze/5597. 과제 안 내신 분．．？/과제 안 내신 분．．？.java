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
		
		// 선언 및 초기화
		int result[] = new int[30];
		
		for(int i=0; i<28; i++) {
			int n = Integer.parseInt(br.readLine());
			
			// 서로 바꾸기
			result[n-1] += 1;
		}
		
		for(int i=0; i<result.length; i++) {
			if(result[i] == 0) {
				System.out.println(i+1);
			}
		}
	}
}