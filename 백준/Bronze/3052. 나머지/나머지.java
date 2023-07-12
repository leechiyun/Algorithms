import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Integer, Integer> hMap = new HashMap<>();
		for(int i=0; i<10; i++) {
			int num = Integer.parseInt(br.readLine());
			if(hMap.get(num % 42) == null) {
				hMap.put(num % 42, 1);
			}else {
				hMap.put(num % 42, hMap.get(num % 42) + 1);
			}
		}
		System.out.println(hMap.size());
	}
}