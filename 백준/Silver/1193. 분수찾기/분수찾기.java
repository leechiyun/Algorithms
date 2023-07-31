import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int x = 1, y = 1;
        int count = 0;

        int up = 1;
        while(count != N){
            for(int i=0; i<up; i++){
                if(up % 2 == 0){
                    x = 1 + i;
                    y = up - i;
                }else{
                    x = up - i;
                    y = 1 + i;
                }

                count++;
                if(count == N)  break;
            }
            up++;
        }

        System.out.println(x + "/" + y);
    }

}