import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
 
        // 가능한 숫자들의 집합을 담을 리스트 초기화
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        // N 한개로 만들 수 있는 dp[1]
        dp.get(1).add(N);
        
        for(int i=2; i<=8; i++){
            // N, NN, NNN, ... 과 같은 수
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<i; j++){
                sb.append(N);
            }
            dp.get(i).add(Integer.parseInt(sb.toString()));
            
            /* dp끼리 만들 수 있는 모든 값
            *  ex> i = 4: 1 + 3, 2 + 2, 3 + 1
            */
            for(int x=1; x<i; x++){
                for(int y=i-x; y>0; y--){
                    for(int numX: dp.get(x)){
                        for(int numY: dp.get(y)) {
                            dp.get(i).add(numX + numY);
                            dp.get(i).add(numX - numY);
                            dp.get(i).add(numX * numY);
                            if(numY != 0) {
                               dp.get(i).add(numX / numY);
                            }
                        }
                    }
                }
            }
            // i는 2부터 시작하여 만족하면 최소값 반환
            if(dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}