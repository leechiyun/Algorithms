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

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int result = 0;
		for(int i=0; i<N; i++) {
			result += Integer.parseInt(str.substring(i, i+1));
		}
		System.out.println(result);
	}
}
