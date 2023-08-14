import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int x = Integer.parseInt(br.readLine());
        int left = 0, right = list.size()-1;
        int count = 0;
        int v = 0;
        while (left != right){
            v = list.get(left) + list.get(right);
            if(v == x){
                count++;
                left++;
            }
            else if(v > x){
                right--;
            }else{
                left++;
            }
        }
        System.out.println(count);
    }
}
