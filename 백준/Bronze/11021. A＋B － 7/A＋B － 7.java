import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			String str[] = br.readLine().split(" ");
			int result = Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
			System.out.println("Case #" + i + ": " + result);
		}
	}
}