import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int N = Integer.parseInt(br.readLine());
		try {
			int a = 0;
			int b = 0;
			String str;
			
			while((str = br.readLine()) != null) {
				String strArray[] = str.split(" ");
				a = Integer.parseInt(strArray[0]);
				b = Integer.parseInt(strArray[1]);
				if(a == 0 && b == 0) {
					break;
				}
				System.out.println(a+b);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}