import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static List<Integer> dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if(is_prime(i)) {
                dp.add(i);
            }
        }
        int start = 0, end = 0;
        int result = 0;
        while (start < dp.size()){
            int sum = 0;
            while(sum < N && end < dp.size()){
                sum += dp.get(end);
                end++;
            }

            if(sum == N){
                result++;
            }

            // 초기화
            start++;
            end = start;
        }
        System.out.println(result);
    }

    // 소수 판별 메소드
    public static boolean is_prime(int number) {

        // 0 과 1 은 소수가 아니다
        if(number < 2) {
            return false;
        }

        // 2 는 소수다
        if(number == 2) {
            return true;
        }

        // 제곱근 함수 : Math.sqrt()
        for(int i = 2; i <= Math.sqrt(number); i++) {

            // 소수가 아닐경우
            if(number % i == 0) {
                return false;
            }
        }
        // 위 반복문에서 약수를 갖고 있지 않는경우 소수다.
        return true;
    }
}

