import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Boolean> map = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String check = st.nextToken();

            if (check.equals("enter")) {
                map.put(name, true);
            }
            if (check.equals("leave")) {
                map.put(name, false);
            }
        }

        StringBuilder sb = new StringBuilder();
        List<String> resultList = new ArrayList<>();
        for (String name : map.keySet()) {
            if (map.get(name)) {
                resultList.add(name);
            }
        }

        Collections.sort(resultList, (s1, s2) -> s2.compareTo(s1));
        for (String result : resultList) {
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

}

