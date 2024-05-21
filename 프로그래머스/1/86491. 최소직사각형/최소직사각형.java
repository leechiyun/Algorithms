class Solution {
    // 1. 가장 큰 값을 하나 찾는다
    // 2. A를 더 큰 값으로 설정하고 B를 구한다.
    public int solution(int[][] sizes) {
        int maxA = Integer.MIN_VALUE;
        int maxB = Integer.MIN_VALUE;
        
        for(int[] size: sizes) {
            if(size[0] < size[1]) {
               maxA = Math.max(maxA, size[1]);
                maxB = Math.max(maxB, size[0]); 
            } else {
                maxA = Math.max(maxA, size[0]);
                maxB = Math.max(maxB, size[1]);
            }
        }

        return maxA * maxB;
    }
}