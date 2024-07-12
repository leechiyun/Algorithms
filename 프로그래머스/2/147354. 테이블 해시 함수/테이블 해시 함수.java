import java.util.*;

class Solution {
    // 1번 col = 기본키
    // col 기준으로 오름차순 정렬, 같으면 1번 컬럼 내림차순
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // 정렬
        Arrays.sort(data, (a, b) -> {
            if(a[col - 1] == b[col - 1]) {
                return Integer.compare(b[0], a[0]);
            }
            
            return Integer.compare(a[col - 1], b[col - 1]);
        });
        
        int result = 0;
        for(int i = row_begin; i <= row_end; i++) {
            int sum = 0;
            for(int j = 0; j < data[i - 1].length; j++) {
                sum += (data[i - 1][j] % (i));
            }
            
            result ^= sum;
        }
            
        return result;
    }
}