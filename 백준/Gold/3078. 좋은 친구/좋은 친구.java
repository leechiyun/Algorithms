import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static String names[];

    // 등수 순서대로 이름이 나열
    // 1. 차례대로 이름을 하나하나 비교하면 O(N^2)
    // 2. 투포인터 사용 (슬라이딩 윈도우)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        names = new String[N];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
        }

        int left = 0;
        int right = K;

        // 슬라이딩 윈도우를 사용하기 위해 K만큼만 미리 계산한다.
        long result = 0;
        for (int i = 0; i <= K; i++) {
            int len = names[i].length();

            map.put(len, map.getOrDefault(len, 0) + 1);
        }


        while(left < N) {
            // 1. left의 길이에 맞고 K 이하인 갯수를 구함
            result += map.getOrDefault(names[left].length(), 1) - 1;

            // 2. 오른쪽의 이름을 추가
            right++;
            if(right < N) {
                map.put(names[right].length(), map.getOrDefault(names[right].length(), 0) + 1);
            }

            // 왼쪽 제거
            map.put(names[left].length(), map.getOrDefault(names[left].length(), 1) - 1);
            left++;
        }

        System.out.println(result);
    }
}