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

		String str = br.readLine();
		int arr[] = new int[26];
		for(int i=0; i<arr.length; i++) {
			arr[i] = -1;
		}
		
		//97
		for(int i=0; i<str.length(); i++) {
			int index = ((int)str.charAt(i)) - 97;
			if(arr[index] == -1) {
				arr[index] = i;
			}
		}
		
		String result = "";
		for(int i=0; i<arr.length; i++) {
			result += arr[i] + " ";
		}
		System.out.println(result.substring(0,result.length()-1));
	}
}