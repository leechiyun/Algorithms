import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int N = Integer.parseInt(br.readLine());
		int a = 0;
		int b = 0;
		
		while(true) {
			String str[] = br.readLine().split(" ");
			a = Integer.parseInt(str[0]);
			b = Integer.parseInt(str[1]);
			if(a == 0 && b == 0) {
				break;
			}
			System.out.println(a+b);
		}
	}
}