import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int N, M;
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		int start = 0;
		int end = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			end = Math.max(end, arr[i]);
		}
		
		int result = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			
			long sum = 0;
			for(int tree: arr) {
				if(tree > mid) {
					sum += tree - mid;
				}
			}
			
			if(sum >= M) {
				result = Math.max(result, mid);
			}
			
			
			if(sum > M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		System.out.println(result);
	}
}