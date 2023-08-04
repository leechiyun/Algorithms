import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> uniqueSet = new HashSet<>();

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            uniqueSet.add(num);
            list.add(num);
        }
        List<Integer> uniqueList = new ArrayList<>(uniqueSet);
        Collections.sort(uniqueList);

        for(int i=0; i<uniqueList.size(); i++){
            map.put(uniqueList.get(i), i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(" ").append(map.get(list.get(i)));
        }
        System.out.println(sb.substring(1));
    }
}