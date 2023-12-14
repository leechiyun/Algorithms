import java.util.*;

class Solution {
    static char dx[] = {'R', 'C', 'J', 'A'}; 
    static char dy[] = {'T', 'F', 'M', 'N'};
    
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < choices.length; i++) {
            int num = choices[i] - 4;
            
            // 왼쪽 값
            if(num < 0) {
                Character key = survey[i].charAt(0);
                map.put(key, map.getOrDefault(key, 0) + Math.abs(num));
            } else {
                Character key = survey[i].charAt(1);
                map.put(key, map.getOrDefault(key, 0) + Math.abs(num));
            }
        }
        
        String answer = "";
        for(int i = 0; i < dx.length; i++) {
            char x = dx[i];
            char y = dy[i];
            
            if(map.getOrDefault(x, 0) > map.getOrDefault(y, 0)) {
                answer += x;
            } else if (map.getOrDefault(x, 0) < map.getOrDefault(y, 0)) {
                answer += y;
            } else {
                if(x <= y) {
                    answer += x;
                } else {
                    answer += y;
                }
            }
        }
        
        return answer;
    }
}