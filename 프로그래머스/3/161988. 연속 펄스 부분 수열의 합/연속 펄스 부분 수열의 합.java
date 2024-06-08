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
        
        long max = Long.MIN_VALUE;
        for (int[] s : sequences) {
            long localMax = s[0];
            long globalMax = s[0];
            
            for (int i = 1; i < N; i++) {
                localMax = Math.max(s[i], localMax + s[i]);
                globalMax = Math.max(globalMax, localMax);
            }
            
            max = Math.max(max, globalMax);
        }
        
        return max;
    }
}