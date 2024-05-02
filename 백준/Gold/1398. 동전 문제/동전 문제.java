import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();

			long money = Long.parseLong(input);
			long sum = 0;
			while (money > 0) {
				long divide = 1;
				int len = calcute(money);
				input = Long.toString(money);

				if (len % 2 == 0 && len >= 2) {
					String subInput = input.substring(0, 2);
					long subMoney = Long.parseLong(subInput);

					if (subMoney >= 25) {
						long n = subMoney - 25;
						n %= 10;
						
						if(subMoney >= 50 || !((n >= 5) && (n <= 9))) {
							divide *= 25;
							for (int i = 0; i < len - 2; i++) {
								divide *= 10;
							}
							
							sum++;
							money -= divide;
							continue;
						}
					}
				}

				if (divide == 1) {
					for (int i = 0; i < len - 1; i++) {
						divide *= 10;
					}
				}

				sum += money / divide;
				money %= divide;
			}

			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}

	static int calcute(long num) {
		int cnt = 0;

		while (num > 0) {
			num /= 10;
			cnt++;
		}
		return cnt;
	}
}