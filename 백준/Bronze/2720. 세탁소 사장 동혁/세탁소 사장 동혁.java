import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> resultList = new ArrayList<>();
        String result = "";
        for(int i=0; i<N; i++){
            int money = Integer.parseInt(br.readLine());
            result = "";

            result += " "+ (int)(money / 25);
            money %= 25;
            result += " "+ (int)(money / 10);
            money %= 10;
            result += " "+ (int)(money / 5);
            money %= 5;
            result += " "+ (int)(money / 1);
            money %= 1;

            resultList.add(result.substring(1));
        }

        for(int i=0; i<resultList.size(); i++){
            System.out.println(resultList.get(i));
        }
    }

}