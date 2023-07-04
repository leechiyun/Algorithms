import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++) {
			String strArray[] = br.readLine().split(" ");
			int a = Integer.parseInt(strArray[0]);
			int b = Integer.parseInt(strArray[1]);
			System.out.println(a + b);
		}
	}
}