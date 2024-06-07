class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        
        int minLeft = 0;
        int minRight = Integer.MAX_VALUE;
        
        int sum = sequence[0];
        while (right < sequence.length) {
            if (sum == k) {
                if (right - left < minRight - minLeft || (right - left == minRight - minLeft && left < minLeft)) {
                    minRight = right;
                    minLeft = left;
                }
                sum -= sequence[left++];
            }
            else if (sum < k) {
                right++;
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            }
            else {
                sum -= sequence[left++];
            }
        }
        
        int[] answer = {minLeft, minRight};
        return answer;
    }
}