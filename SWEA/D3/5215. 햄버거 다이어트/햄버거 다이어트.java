import java.util.*;

class Solution {
    public static int N, L, result;
    public static int[] tastes, cals;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            //재료의 수, 제한 칼로리
            N = sc.nextInt();
            L = sc.nextInt();

            tastes = new int[N];
            cals = new int[N];
            result = 0;

            //재료에 대한 민기의 맛에 대한 점수와 칼로리
            for (int i = 0; i < N; i++) {
                tastes[i] = sc.nextInt();
                cals[i] = sc.nextInt();
            }
            combination(0, 0, 0);
            System.out.println("#" + test_case + " " + result);
        }
    }
    public static void combination(int idx, int sumTaste, int sumCal) {
        if(sumCal > L) return;

        if(idx == N) {
            if(sumTaste > result) {
                result = sumTaste;
            }
            return;
        }

        combination(idx+1, sumTaste+tastes[idx], sumCal+cals[idx]); //제료를 선택한 경우
        combination(idx+1, sumTaste, sumCal); //재료를 선택하지 않은 경우
    }
}