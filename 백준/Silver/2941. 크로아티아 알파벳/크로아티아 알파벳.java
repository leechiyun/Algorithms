import java.awt.image.SampleModel;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String sample[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String inputString = br.readLine();
		
		int result = 0;
		String twoString = "";
		String threeString = "";
		for(int i=0; i<inputString.length(); i++) {
			twoString = "";
			threeString = "";
			if(i < inputString.length() - 1) {
				twoString = inputString.substring(i, i+2);			
			}
			if(i < inputString.length() - 2) {
				threeString = inputString.substring(i, i+3);
				if(threeString.equals("dz=")) {
					i += 2;
					result++;
					continue;
				}
			}
			for(int j=0; j< sample.length; j++) {
				if(twoString.equals(sample[j])) {
					i++;
					break;
				}
			}
			result++;
		}
		System.out.println(result);
	}
}