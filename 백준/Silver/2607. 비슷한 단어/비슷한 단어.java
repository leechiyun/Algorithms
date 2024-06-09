import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        String mainWord = br.readLine();
        List<String> others = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            others.add(br.readLine());
        }

        //
        int mainWordLen = mainWord.length();
        Map<Character, Integer> mainWordMap = new HashMap<>();
        for (int i = 0; i < mainWordLen; i++) {
            char c = mainWord.charAt(i);
            mainWordMap.put(c, mainWordMap.getOrDefault(c, 0) + 1);
        }

        int result = 0;
        for(String other: others) {
            if(other.length() > mainWordLen + 1 || other.length() < mainWordLen - 1)
                continue;

            // 메인 문자열과 다른 문자열의 차이로 비교한다.
            Map<Character, Integer> otherWordMap = new HashMap<>();
            for (int i = 0; i < other.length(); i++) {
                char c = other.charAt(i);
                otherWordMap.put(c, otherWordMap.getOrDefault(c, 0) + 1);
            }

            // main, other 둘 중 큰걸로 비교
            for(char key: mainWordMap.keySet()) {
                otherWordMap.put(key, Math.abs(otherWordMap.getOrDefault(key, 0) - mainWordMap.get(key)));
            }

            int cnt = 0;
            for(char otherKey: otherWordMap.keySet()) {
                cnt += otherWordMap.get(otherKey);
            }

            if(cnt <= 1 || (mainWordLen == other.length() && cnt == 2)) {
                result++;
            }
        }

        System.out.println(result);
    }
}