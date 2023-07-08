import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		double result = 0;
		double maxValue = Collections.max(list);
		for(int i=0; i<N; i++) {
			result += (list.get(i) / maxValue) * 100;
		}
		
		System.out.println(result / N);
	}
}