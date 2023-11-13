
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
	static List<Character> threeSixNine = Arrays.asList('3', '6', '9');
	
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(threeSixNineGame(String.valueOf(i))).append(" ");
		}
		
		System.out.println(sb);
	}
	
	private static String threeSixNineGame(String str) {
		String result = "";
		for(char c: str.toCharArray()) {
			if(threeSixNine.contains(c)) {
				result += "-";
			}
		}
		
		if(result.equals("")) {
			return str;
		}
		return result;
		
	}
}
