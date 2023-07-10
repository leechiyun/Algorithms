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
		int max = 0;
		int result = 0;
		for(int i=1; i<=9; i++) {
			int input = Integer.parseInt(br.readLine());
			if(max < input) {
				max = input;
				result = i;
			}
		}
		
		System.out.println(max);
		System.out.println(result);
	}
}
