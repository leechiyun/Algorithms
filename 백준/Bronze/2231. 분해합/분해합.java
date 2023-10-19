import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());

        Long output = 0L;
        for (Long i = 1L; i < N; i++) {
            Long result = function(i);

            if(result.equals(N)){
                output = i;
                break;
            }
        }

        System.out.println(output);
    }

    public static Long function(Long num){
        Long divide = 10L;
        Long sum = num;
        while(num / divide > 0){
            sum += num % divide;
            num /= 10;
        }

        sum += num % 10L;

        return sum;
    }
}

