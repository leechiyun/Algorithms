import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            
            map.put(name, 1);
        }

        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            String name = br.readLine();

            // 중복 되는지 확인
            if(map.containsKey(name)){
                list.add(name);
            }
        }
        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for(String name: list){
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}

