import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        long result = 0;
        int num = 0;
        long pow = 1;
        for (int i = n.length()-1; i >= 0; i--) {
            char c = n.charAt(i);
            if (c>='0' && c<='9')
                num = c - '0';
            else
                num = c - 55;
            result += num * pow;
            pow *= b;
        }
        System.out.println(result);
    }

}