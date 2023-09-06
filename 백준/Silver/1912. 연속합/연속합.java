import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i <N; i++) {
            int n = Integer.parseInt(st.nextToken());

            if(n >= 0){
                input.add(n);
            }else{
                if(!input.isEmpty()){
                    int sum = 0;
                    for (int value:input) {
                        sum += value;
                    }
                    input = new ArrayList<>();

                    list.add(sum);
                }
                list.add(n);
            }
        }

        if(!input.isEmpty()){
            int sum = 0;
            for (int value:input) {
                sum += value;
            }
            input = new ArrayList<>();

            list.add(sum);
        }
        dp = new int[list.size()];
        dp[0] = list.get(0);

        for(int i=1; i<list.size(); i++){
            dp[i] = Math.max(list.get(i), dp[i-1]+list.get(i));
        }

        int max = -1000;
        for(int num: dp){
            if(num > max) max = num;
        }
        System.out.println(max);
    }
}