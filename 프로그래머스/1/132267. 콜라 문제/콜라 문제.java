class Solution {
    static int N = 0;
    
    public int solution(int a, int b, int n) {
        N = n;
        
        int answer = 0;
        while(N / a >= 1) {
            answer += (N / a) * b;
            N = (N / a) * b + (N % a);
        }
        
        return answer;
    }
}