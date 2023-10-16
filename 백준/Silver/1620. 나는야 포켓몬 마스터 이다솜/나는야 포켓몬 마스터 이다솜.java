import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> mapName = new HashMap<>();
        HashMap<Integer, String> mapNumber = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String poketmon = br.readLine();

            mapName.put(poketmon, i);
            mapNumber.put(i, poketmon);
        }

        // 문제
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String q = br.readLine();

            if(isNumber(q)){
                int num = Integer.parseInt(q);

                sb.append(mapNumber.get(num));
            }else{
                sb.append(mapName.get(q));
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isNumber(String q) {
        try {
            Integer.parseInt(q);
            return true;

        } catch (NumberFormatException ex){
            return false;
        }
    }

}

