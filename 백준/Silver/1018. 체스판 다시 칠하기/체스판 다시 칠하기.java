import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2차원 배열 입력받기
        boolean arr[][] = new boolean[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for (int j=0; j<M; j++){
                if(str.charAt(j) == 'B')    arr[i][j] = true;
                else arr[i][j] = false;
            }
        }

        int count = 0;
        int min = 64;
        for(int x=0; x<= N-8; x++) {
            for (int y = 0; y <= M - 8; y++) {
                boolean check = arr[x][y];
                count = 0;
                for (int i = x; i < x + 8; i++) {
                    for (int j = y; j < y + 8; j++) {
                        if (check != arr[i][j]) count++;
                        if (j < y + 7) check = !check;
                    }
                }
                if (count < min) min = count;

                check = !arr[x][y];
                count = 0;
                for (int i = x; i < x + 8; i++) {
                    for (int j = y; j < y + 8; j++) {
                        if (check != arr[i][j]) count++;
                        if (j < y + 7) check = !check;
                    }
                }
                if (count < min) min = count;
            }
        }
        System.out.println(min);
    }
}