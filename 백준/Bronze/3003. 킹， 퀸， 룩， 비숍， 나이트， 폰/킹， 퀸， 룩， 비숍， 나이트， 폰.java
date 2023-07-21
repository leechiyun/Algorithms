import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int arr[] = { 1, 1, 2, 2, 2, 8 };
		ArrayList<Integer> result=new ArrayList<>();
		int num = st.countTokens();
		for(int i=0; i<num; i++) {
			result.add(arr[i] - Integer.parseInt(st.nextToken()));
		}
		
		String resultString = "";
		for(int i=0; i<result.size(); i++) {
			resultString += result.get(i) + " ";
		}
		System.out.println(resultString.substring(0, resultString.length()-1));
	}
}
