import java.util.*;

class Solution {
    static String numbers;
    static boolean visited[];
    static Set<Integer> resultList = new HashSet<>();
    
    public int solution(String numbers) {
        this.numbers = numbers;
        visited = new boolean[numbers.length()];
        
        // dfs로 넣고 안넣고 가능
        dfs("", 0);
        
        int answer = 0;
        for(int num: resultList) {
            if(isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(String results, int length) {
        if(length == numbers.length()) {
            if(!results.equals("")) {
                resultList.add(Integer.parseInt(results));
            }
            
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(results + numbers.charAt(i), length + 1);
                dfs(results, length + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int number) {
        if(number <= 1) {
            return false;
        }
        
        if(number == 2) {
            return true;
        }
        
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}