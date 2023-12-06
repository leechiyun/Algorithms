import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        // 멈춘 과제 Stack
        Stack<String> stack = new Stack<>();
        
        // 과제와 남은 시간을 나타낼 Map
        Map<String, Integer> remainMap = new HashMap<>();
        Map<String, int[]> timeMap = new HashMap<>();
        for(String[] plan: plans){
            remainMap.put(plan[0], Integer.parseInt(plan[2]));
            
            String split[] = plan[1].split(":");
            int time[] = new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
            timeMap.put(plan[0], time);
        }
        List<String> startList = new ArrayList<>(timeMap.keySet());
        Collections.sort(startList, (a, b) -> {
            int hourA = timeMap.get(a)[0];
            int minuteA = timeMap.get(a)[1];
            int hourB = timeMap.get(b)[0];
            int minuteB = timeMap.get(b)[1];
            
            if(hourA == hourB) {
                return minuteA - minuteB;
            }
            return hourA - hourB;
        });
        
        List<String> results = new ArrayList<>();
        for(int i = 0; i < startList.size() - 1; i++) {
            int time = (timeMap.get(startList.get(i + 1))[0] - timeMap.get(startList.get(i))[0])
                * 60 + (timeMap.get(startList.get(i + 1))[1] - timeMap.get(startList.get(i))[1]);
            
            String currName = startList.get(i);
            int remainTime = time - remainMap.get(currName);
            if(remainTime >= 0) {
                // reminMap 삭제
                remainMap.remove(currName);
                results.add(currName);
                
                while(remainTime > 0 && !stack.isEmpty()) {
                    currName = stack.pop();
                    
                    int prevTime = remainTime;
                    remainTime = remainTime - remainMap.get(currName);
                    if(remainTime >= 0) {
                        // reminMap 삭제
                        remainMap.remove(currName);
                        results.add(currName);
                    } else{
                        remainMap.put(currName, remainMap.get(currName) - prevTime);
                        stack.push(currName);
                    }       
                
                }
            } else{
                remainMap.put(currName, remainMap.get(currName) - time);
                stack.push(currName);
            }
        }
        stack.push(startList.get(startList.size() - 1));
        
        while(!stack.isEmpty()){
            results.add(stack.pop());
        }
        
        String[] answer = new String[results.size()];
        for(int i=0; i<results.size(); i++){
            answer[i] = results.get(i);
        }
        
        return answer;
    }
}