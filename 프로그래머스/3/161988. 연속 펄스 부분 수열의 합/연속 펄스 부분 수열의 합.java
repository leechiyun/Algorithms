class Solution {
    public long solution(int[] sequence) {
        int N = sequence.length;
        
        int[][] sequences = new int[2][N];
        for (int i = 0; i < N; i++) {
            int n = sequence[i];
            
            if (i % 2 == 0) {
                sequences[0][i] = n;
                sequences[1][i] = -n;
            } else {
                sequences[1][i] = n;
                sequences[0][i] = -n;
            }
        }
        
        
        long dp[][] = new long[2][N];
        
        dp[0][0] = sequences[0][0];
        dp[1][0] = sequences[1][0];
        
        long max = Long.MIN_VALUE;
        for(int i = 0; i < 2; i++) {
            max = Math.max(max, dp[i][0]);
            
            long localMax = Long.MIN_VALUE;
            for(int j = 1; j < N; j++) {
                dp[i][j] = Math.max(dp[i][j - 1] + sequences[i][j], sequences[i][j]);
                localMax = Math.max(localMax, dp[i][j]);
            }
            
            max = Math.max(max, localMax);
        }
        
        return max;
    }
}