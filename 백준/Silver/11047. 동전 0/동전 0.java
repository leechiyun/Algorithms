import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int num = 0;
        boolean flag = false;
        int count = 0;
        Collections.sort(list, (a, b) -> b -a);
        for (int i = 0; i < N; i++) {
            num = list.get(i);
            if(K / num >= 1){
                count += Math.floor(K / num);
                K %= num;
            }

            if(K == 0){
                flag = true;
                break;
            }
        }

        if(flag){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }
    }
}