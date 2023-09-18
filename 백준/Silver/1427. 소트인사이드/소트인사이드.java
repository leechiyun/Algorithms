import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char cArr[] = br.readLine().toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cArr.length; i++) {
            list.add(Integer.parseInt(String.valueOf(cArr[i])));
        }
        Collections.sort(list, (a, b)-> b-a);

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        System.out.println(sb);
    }
}

