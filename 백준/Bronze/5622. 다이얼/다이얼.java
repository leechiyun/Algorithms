import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String inputArr[] = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
		int result = str.length();
		for(int i=0; i<str.length(); i++) {
			Character c = str.charAt(i);
			for(int j=0; j<inputArr.length; j++) {
				if(inputArr[j].contains(c.toString())) {
					result += j;
				}
			}
		}
		System.out.println(result);
	}
}