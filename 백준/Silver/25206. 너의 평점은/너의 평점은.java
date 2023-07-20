import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		HashMap<String, Double> scoreMap = new HashMap<>();
		scoreMap.put("A+", 4.5);
		scoreMap.put("A0", 4.0);
		scoreMap.put("B+", 3.5);
		scoreMap.put("B0", 3.0);
		scoreMap.put("C+", 2.5);
		scoreMap.put("C0", 2.0);
		scoreMap.put("D+", 1.5);
		scoreMap.put("D0", 1.0);
		scoreMap.put("F", 0.0);

		String input;
		double sum = 0;
		double count = 0;

		for(int i=0; i<20; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String scoreTitle = st.nextToken();
			double s = Double.parseDouble( st.nextToken());
			String scoreName = st.nextToken();

			if (!scoreName.equals("P")) {
				sum += s * scoreMap.get(scoreName);
				count += s;
			}
		}
		System.out.println(sum / count);

	}
}