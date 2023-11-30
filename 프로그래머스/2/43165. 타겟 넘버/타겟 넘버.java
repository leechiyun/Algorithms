class Solution {
    static int answer = 0;
    static int target = 0;
    static int numbers[];
    
    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        
        dfs(0, 0);
        
        return answer;
    }
    
    private static void dfs(int result, int len) {
        if(len == numbers.length) {
            if(result == target) {
                answer++;
            }
            return;
        }
        if(len < numbers.length) {
            dfs(result + numbers[len], len + 1);
            dfs(result - numbers[len], len + 1);
        }    
    }
}