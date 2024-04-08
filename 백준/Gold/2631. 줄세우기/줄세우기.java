import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int N;
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(N - LIS(arr));
	}
	
	
	public static int LIS(int arr[]) {
		TreeSet<Integer> ts = new TreeSet<>();
		
		for(int n: arr) {
			Integer num = ts.ceiling(n);
			
			if(num != null) {
				ts.remove(num);
			} 
			ts.add(n);
		}
		
		return ts.size();
	}
}