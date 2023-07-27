import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int arr[][] = new int[100][100];
        int N = Integer.parseInt(br.readLine());
        int x=0, y=0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            for(int j=0; j<10; j++){
                for(int k=0; k<10; k++){
                    if(x+j < 100 && y+k < 100){
                        arr[x+j][y+k] = 1;
                    }
                }
            }
        }
        int result = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(arr[i][j] == 1)  result++;
            }
        }

        System.out.println(result);
    }
}