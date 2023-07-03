import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int H = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		int time = Integer.parseInt(br.readLine());
		
		// M이 0 밑으로 가서 H - 1을 했을때 -는 불가능
		M += time;
		while(M >= 60) {
			M -= 60;
			H += 1;
			if(H > 23) {
				H -= 24;
			}
		}
		
		System.out.println(H + " " + M);
	}
}