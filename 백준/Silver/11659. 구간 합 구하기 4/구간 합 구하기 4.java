import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //첫째 줄에 수의 개수
        int m = Integer.parseInt(st.nextToken()); //합을 구해야하는 횟수

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1] + tmp;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            System.out.println(arr[end] -  arr[start-1]);
        }
    }
}