import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static char arr[];
    public static void recursion(int start, int len){
        // 재귀의 탈출 조건
        if(len < 1){
            return;
        }

        for (int i = start + len; i < start + 2 * len; i++) {
            arr[i] = ' ';
        }
        recursion(start, len/3);
        recursion(start + len * 2, len/3);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null){
            int N = Integer.parseInt(str);

            int len = (int)Math.pow(3, N);
            arr = new char[len];
            for (int i = 0; i < len; i++) {
                arr[i] = '-';
            }

            recursion(0, len / 3);

            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}

