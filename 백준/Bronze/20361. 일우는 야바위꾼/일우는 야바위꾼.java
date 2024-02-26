import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		

			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			boolean arr[] = new boolean[N + 1];
			arr[X] = true;	// 이곳에 공이 들어있다
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				swap(arr, x, y);
			}
			
			for(int i = 1; i <= N; i++) {
				if(arr[i]) {
					sb.append(i);
					break;
				}
			}
		
		System.out.println(sb);
		
	}
	
	static void swap(boolean arr[], int x, int y) {
		boolean temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}