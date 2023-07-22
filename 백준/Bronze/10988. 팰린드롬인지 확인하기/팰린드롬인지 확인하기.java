import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int result = 1;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) != S.charAt(S.length() - 1 - i)) {
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }
}