import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        List<Integer> bigList = new ArrayList<>();
        List<Integer> smallList = new ArrayList<>();
        
        for(int i=0; i<sizes.length; i++) {
            int a = sizes[i][0];
            int b = sizes[i][1];
            
            if(a > b) {
                bigList.add(a);
                smallList.add(b);
            } else {
                bigList.add(b);
                smallList.add(a);
            }
        }
        
        int answer = Collections.max(bigList) * Collections.max(smallList);
        return answer;
    }
}