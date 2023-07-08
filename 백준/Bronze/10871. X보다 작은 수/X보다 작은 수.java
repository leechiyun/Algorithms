import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int X = Integer.parseInt(str[1]);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		String result = "";
		for(int i=0; i<N; i++) {
			if(list.get(i) < X) {
				result += list.get(i) + " ";
			}
		}
		
		
		System.out.println(result.substring(0, result.length()-1));
	}
}