import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Map<Integer, String> nameMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if(nameMap.get(age) == null){
                nameMap.put(age, name);
                list.add(age);
            }else{
                nameMap.put(age, nameMap.get(age) +" " + name);
            }
        }
        Collections.sort(list);

        for(int i=0; i< list.size(); i++){
            String strResult[] = nameMap.get(list.get(i)).split(" ");

            for(int j=0; j< strResult.length; j++){
                System.out.println(list.get(i) + " " + strResult[j]);
            }
        }
    }
}