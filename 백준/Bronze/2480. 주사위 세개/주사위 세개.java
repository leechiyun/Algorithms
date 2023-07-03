import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		int c = Integer.parseInt(str[2]);
		
		int result = 0;
		
		//같은 눈 3 개
		if(a == b && a == c) {
			result += 10000 + a * 1000;
		}
		else {
			if(a == b || a == c) {
				result += 1000 + a * 100;
			}
			else if(b == c) {
				result += 1000 + b * 100;
			}
			else {
				int maxValue = Math.max(a, b);
				maxValue = Math.max(maxValue, c);
				
				result = maxValue * 100;
			}
		}
		
		
		System.out.println(result);
	}
}
