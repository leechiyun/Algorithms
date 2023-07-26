import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][M];

        for(int i=0; i<2*N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                arr[i%N][j] += Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            String result = "";
            for(int j=0; j<M; j++){
                result += " " + arr[i][j];
            }
            System.out.println(result.substring(1));
        }
    }
}