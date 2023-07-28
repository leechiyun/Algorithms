import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long result = 2;
        for(int i=0; i<N; i++){
            result += Math.pow(2, i);
        }
        result = (long)Math.pow(result, 2);
        System.out.println(result);
    }

}