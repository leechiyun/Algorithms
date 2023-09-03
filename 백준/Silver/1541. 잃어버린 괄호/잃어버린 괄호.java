import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> numList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        // 토큰이 빌때까지
        while(st.hasMoreTokens()){
            StringTokenizer plusToken = new StringTokenizer(st.nextToken(), "+");
            int sum = 0;
            while (plusToken.hasMoreTokens()){
                sum += Integer.parseInt(plusToken.nextToken());
            }
            numList.add(sum);
        }
        int result = numList.get(0);
        for (int i = 1; i < numList.size(); i++) {
            result -= numList.get(i);
        }
        System.out.println(result);
    }
}