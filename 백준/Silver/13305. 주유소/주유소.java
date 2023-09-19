import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static List<Long> valueList = new ArrayList<>();
    static List<Long> lengthList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer stLength = new StringTokenizer(br.readLine(), " ");
        StringTokenizer stValue = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            valueList.add(Long.parseLong(stValue.nextToken()));
            if(i < N -1){
                lengthList.add(Long.parseLong(stLength.nextToken()));
            }
        }

        // 거리 계산
        Long min = Long.MAX_VALUE;
        Long result = 0L;
        for (int i = 0; i < N-1; i++) {
            if(min > valueList.get(i)){
                min = valueList.get(i);
            }

            result += min * lengthList.get(i);
        }

        System.out.println(result);
    }
}

