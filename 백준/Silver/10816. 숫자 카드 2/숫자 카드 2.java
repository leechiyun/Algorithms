import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            Long num = Long.parseLong(st.nextToken());

            if(map.get(num) != null){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1L);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            Long num = Long.parseLong(st.nextToken());

            if(map.get(num) != null){
                sb.append(map.get(num));
            }else{
                sb.append(0);
            }

            if(i != M-1){
                sb.append(" ");
            }
        }

        System.out.println(sb);


    }
}

