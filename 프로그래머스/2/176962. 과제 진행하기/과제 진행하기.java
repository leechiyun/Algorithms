import java.util.*;

class Solution {
    
    static class HomeWork {
        String name;
        int hour, minute;
        int playTime;
        
        public HomeWork(String name, int hour, int minute, int playTime) {
            this.name = name;
            this.hour = hour;
            this.minute = minute;
            this.playTime = playTime;
        }
        
        public int calculateTime(HomeWork other) {
            int m = other.minute - this.minute;
            int h = other.hour - this.hour;
            
            return 60 * h + m;
        }
        
        public String toString() {
            return this.name + " " + this.playTime;
        }
    }
    
    // 가장 최근에 멈춘 것부터 시작 (stack)
    public String[] solution(String[][] plans) {
        PriorityQueue<HomeWork> pq = new PriorityQueue<>((a, b) -> {
            if(a.hour == b.hour)
                return Integer.compare(a.minute, b.minute);
            return Integer.compare(a.hour, b.hour);
        });
        
        for(String plan[]: plans) {
            String time[] = plan[1].split(":");
            
            pq.offer(new HomeWork(plan[0], Integer.parseInt(time[0]), Integer.parseInt(time[1]), 
                                  Integer.parseInt(plan[2])));
        }
        
        List<String> result = new ArrayList<>();
        
        // 미뤄둔 일을 저장할 stack
        Stack<HomeWork> stack = new Stack<>();
        HomeWork cur = pq.poll();
        while(!pq.isEmpty()) {
            HomeWork next = pq.poll();
            
            // 다음 일 동안 얼마만큼의 일을 할 수 있는지 확인
            int remainTime = cur.calculateTime(next);
            
            // 일하는 시간 보다 남은 시간이 클 경우,
            // 스택에서 남은 일을 마저한다.
            if(remainTime >= cur.playTime) {
                result.add(cur.name);
                remainTime -= cur.playTime;
                
                while(remainTime > 0 && !stack.isEmpty()) {
                    cur = stack.pop();
                    
                    if(remainTime >= cur.playTime) {
                        remainTime -= cur.playTime;
                        result.add(cur.name);
                    } else {
                        cur.playTime -= remainTime;
                        stack.push(cur);
                        remainTime = 0;
                    }
                }
            }
            else {
                cur.playTime -= remainTime;
                stack.push(cur);
            }
            
            cur = next;
        }
        stack.push(cur);
        while(!stack.isEmpty()) {
            result.add(stack.pop().name);
        }
        
        String[] answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}