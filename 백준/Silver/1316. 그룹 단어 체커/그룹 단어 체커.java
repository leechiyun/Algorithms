import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S[] = null;
        int count = 0;
        for(int i=0; i<N; i++){
            S = br.readLine().split("");
            Set<String> set = new HashSet<>();
            count++;
            for(int j=0; j<S.length; j++){
                if(j+1 < S.length && S[j].equals(S[j+1]))    continue;
                
                if(!set.contains(S[j])){
                    set.add(S[j]);
                }else {
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}