import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<N; i++) {
			String str[] = br.readLine().split(" ");
			String result = Integer.toString(Integer.parseInt(str[0]) + Integer.parseInt(str[1]));
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}