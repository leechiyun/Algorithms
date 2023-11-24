import java.util.*;

/*
* 1. 배포일 구하기
* 2. 시작 배포일 보다 작은 값은 함께 배포
*/
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> leftProgresses = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++){
            leftProgresses.add(calculate(progresses[i], speeds[i]));
        }
        
        int start = leftProgresses.get(0);
        int count = 1;
        List<Integer> results = new ArrayList<>();
        for(int i = 1; i < leftProgresses.size(); i++) {
            if(start < leftProgresses.get(i)) {
                start = leftProgresses.get(i);
                results.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        results.add(count);
        
        
        int[] answer = new int[results.size()];
        for(int i = 0; i < results.size(); i++){
            answer[i] = results.get(i);
        }
        
        return answer;
    }
    
    private static int calculate(int progress, int speed) {
        double leftProgress = 100 - progress;
        
        return (int)Math.ceil(leftProgress / speed);
    }
}