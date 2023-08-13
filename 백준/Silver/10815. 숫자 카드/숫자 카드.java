import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else {
                map.put(num, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                sb.append(1);
            }else {
                sb.append(0);
            }
            sb.append(" ");
        }

        System.out.println(sb);
    }
}