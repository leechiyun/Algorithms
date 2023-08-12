import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stringList.add(br.readLine());
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            for (String value : stringList) {
                if(value.equals(input)) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}