import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		ArrayList<String> resultList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String string[] = br.readLine().split(" ");
			int num = Integer.parseInt(string[0]);
			String S = string[1];
			String tempString = "";
			for(int j=0; j<S.length(); j++) {
				for(int k=0; k<num; k++) {
					tempString += S.charAt(j);
				}
			}
			resultList.add(tempString);
		}
		
		for(int i=0; i<resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
	}
}