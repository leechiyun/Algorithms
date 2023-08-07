import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(map.get(y) == null){
                List<Integer> xList = new ArrayList<>();
                xList.add(x);
                map.put(y, xList);
            }else{
                List<Integer> xList = map.get(y);
                xList.add(x);
                map.put(y, xList);
            }
            set.add(y);
        }
        List<Integer> setList = new ArrayList<>(set);
        Collections.sort(setList);

        for(int i=0; i< setList.size(); i++){
            List<Integer> output = map.get(setList.get(i));
            Collections.sort(output);
            for(int j=0; j< output.size(); j++){
                System.out.println(output.get(j) + " " + setList.get(i));
            }
        }
    }
}