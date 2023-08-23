import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            String str =br.readLine();
            if(str.length() >= M){
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        // for loop (keySet())
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            if(map.get(a)== map.get(b)){
                if(a.length() == b.length()){
                    return a.compareTo(b);
                }else{
                    return b.length() - a.length();
                }
            }else{
                return map.get(b) - map.get(a);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String result : list) {
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}