import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(br.readLine());
        }

        list = list.stream().distinct().collect(Collectors.toList());
        Collections.sort(list);
//        for(int i=0; i<N-1; i++){
//            for(int j=i+1; j<N; j++){
//                if(list.get(i).length() > list.get(j).length()){
//                    String temp = "";
//                    temp = list.get(i);
//                    list.set(i, list.get(j));
//                    list.set(j, temp);
//                }
//            }
//        }
        Collections.sort(list, (a, b) -> a.length() - b.length());

        for(int i=0; i< list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}