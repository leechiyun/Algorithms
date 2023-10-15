import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<String, Integer> map = new HashMap<>();

        map.put("ChongChong", 1);
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String name1 = st.nextToken();
            String name2 = st.nextToken();

            if(map.get(name1) != null){
                if(map.get(name2) != null){
                    map.put(name2, map.get(name2) + 1);
                }else{
                    map.put(name2, 1);
                }
            }
            if(map.get(name2) != null){
                if(map.get(name1) != null){
                    map.put(name1, map.get(name1) + 1);
                }else{
                    map.put(name1, 1);
                }
            }
        }
        System.out.println(map.size());
    }

}

