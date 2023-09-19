import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static List<Long> valueList = new ArrayList<>();
    static List<Long> lengthList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Long distance = 0L;
        Long current = 0L;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N-1; i++) {
            Long num = Long.parseLong(st.nextToken());

            lengthList.add(num);
            distance += num;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            valueList.add(Long.parseLong(st.nextToken()));

            if(i < N - 1){
                current += valueList.get(i) * lengthList.get(i);
            }
        }

        // 거리 계산
        Long result = 0L;
        for (int i = 0; i < N-1; i++) {
            if(current > valueList.get(i) * distance){
                result += valueList.get(i) * distance;
                break;
            }

            result += valueList.get(i) * lengthList.get(i);
            distance -= lengthList.get(i);
            current -= valueList.get(i) * lengthList.get(i);
        }

        System.out.println(result);
    }
}

