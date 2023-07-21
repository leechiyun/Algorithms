import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String result = "";
		for(int i=0; i<N; i++) {
			result = "";
			for(int j=N-i-1; j>0; j--) {
				result += " ";
			}
			for(int j=0; j<2*i+1; j++) {
				result += "*";
			}
			System.out.println(result);
		}
		for(int i=0; i<N-1; i++) {
			result = "";
			for(int j=0; j<i+1; j++) {
				result += " ";
			}
			for(int j=0; j<2*(N-1-i)-1; j++) {
				result += "*";
			}
			System.out.println(result);
		}
	}
}