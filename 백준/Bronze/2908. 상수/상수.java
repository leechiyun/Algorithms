import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ArrayList<Integer> list = new ArrayList<>();
		while(st.hasMoreTokens()) {
			StringBuffer sb = new StringBuffer(st.nextToken());
			list.add(Integer.parseInt(sb.reverse().toString()));
		}
		System.out.println(Collections.max(list));
	}
}