import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 시작 ~ 
		Queue<Integer> eats = new ArrayDeque<>();
		int checked[] = new int[d + 1];
		int count = 0;
		for(int i = 0; i < k; i++) {
			if(checked[arr[i]] == 0) {
				count++;
			}
			eats.add(arr[i]);
			checked[arr[i]]++;
		}
		
		// 쿠폰 증정
		if(checked[c] == 0) {
			count++;
		}
		
		int max = count;
		
		int start = 0;
		int end = k - 1;
		while(start < N) {
			start++;
			end = (end + 1) % N;
			
			int outSusi = eats.poll();
			checked[outSusi]--;
			if(checked[outSusi] == 0) {
				count--;
			}
			if(c == outSusi && checked[c] == 0) {
				count++;
			}
			
			if(checked[arr[end]] == 0) {
				count++;
			}
			if(c == arr[end] && checked[c] == 0) {
				count--;
			}
			eats.add(arr[end]);	
			checked[arr[end]]++;
			
			if(count > max) {
				max = count;
			}
		}
		
		System.out.println(max);
	}

}