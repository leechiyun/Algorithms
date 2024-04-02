import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final long MOD = 1_000_000_000; // 모듈러 값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long start = Long.parseLong(st.nextToken());
		long end = Long.parseLong(st.nextToken());

		System.out.println((G(end) - G(start - 1) + MOD) % MOD);
	}
	
	// 구간합 G(n) = F(n+2) - 1
	private static long G(long n) {
		return fibMatrix(n + 2) - 1;
	}

	private static long[][] multiply(long[][] a, long[][] b) {
		long[][] c = new long[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % MOD;
				}
			}
		}
		return c;
	}

	private static long[][] power(long[][] a, long n) {
		if (n == 0) {
			return new long[][] { { 1, 0 }, { 0, 1 } };
		}
		long[][] x = power(a, n / 2);
		x = multiply(x, x);
		if (n % 2 == 1) {
			x = multiply(x, a);
		}
		return x;
	}

	private static long fibMatrix(long n) {
		long[][] m = power(new long[][] { { 1, 1 }, { 1, 0 } }, n);
		return m[0][1];
	}
}