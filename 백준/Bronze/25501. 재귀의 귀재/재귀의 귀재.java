import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int count = 0;
    public static int recursion(String s, int l, int r){
        // 재귀의 탈출 조건
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else {
            count++;
            return recursion(s, l+1, r-1);
        }
    }
    public static int isPalindrome(String s){
        // 맨 처음과 마지막부터 시작하여 Palindrome 인지 재귀 함수를 이용하여 구현
        count++;
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            count = 0;
            String input = br.readLine();
            sb.append(isPalindrome(input)).append(" ").append(count).append("\n");
        }

        System.out.println(sb);
    }

}

