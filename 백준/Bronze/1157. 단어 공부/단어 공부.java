import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        S = S.toUpperCase();
        HashMap<Character, Integer> map = new HashMap<>();
        Character c;
        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);

            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        int max = Collections.max(map.values());
        int count = 0;
        Character result = null;
        for (Character character : map.keySet()) {
            if (max == map.get(character)) {
                result = character;
                count++;
            }
        }

        System.out.println(count == 1 ? result : '?');
    }
}