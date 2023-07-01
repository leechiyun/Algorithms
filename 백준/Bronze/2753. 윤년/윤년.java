import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		int result = 0;
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			result = 1;
		}
		
		System.out.println(result);
	}
}