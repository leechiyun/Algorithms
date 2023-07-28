import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long n = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        long num = 0;
        long pow = 1;
        while(n / pow >= 1){
            pow *= b;
        }
        String result = "";
        while(pow > 1){
            pow /= b;
            num = n / pow;

            if(num >= 10){
                result += (char) (55 + num);
            } else{
                result += num;
            }

            n %= pow;
        }

        System.out.println(result);
    }

}