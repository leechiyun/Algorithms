import java.util.*;

class Solution {
    static class 시간 {
        int h, m;
        
        public 시간(int h, int m) {
            this.h = h;
            this.m = m;
        }
        
        public 시간(String h, String m) {
            this.h = Integer.parseInt(h);
            this.m = Integer.parseInt(m);
        }
        
        public void add(int m) {
            this.m += m;
            
            if(this.m >= 60) {
                this.h += this.m / 60;
                this.m %= 60;
            }
        }
        
        public int compare(시간 other) {
            if(this.h == other.h) {
                return Integer.compare(this.m, other.m);
            }
            
            return Integer.compare(this.h, other.h);
        }
        
        public String toString() {
            return this.h + ":" + this.m;
        }
    }
    
    static class 방 {
        시간 s, e;
        
        public 방(시간 s, 시간 e) {
            this.s = s;
            this.e = e;
        }
        
        // 방끼리 겹치는지 확인
        public boolean x(방 other) {
            // 안겹치는 것 찾는게 간편
            int ms = this.s.h * 60 + this.s.m;
            int me = this.e.h * 60 + this.e.m;
            
            int os = other.s.h * 60 + other.s.m;
            int oe = other.e.h * 60 + other.e.m;
            
            
            if(oe <= ms) {
                return false;
            }
            
            if(me <= os) {
                return false;
            }
            
            return true;
        }
        
        public String toString() {
            return this.s + " / " + this.e;
        }
    }
    
    // 손님이 이용하고 10분 뒤에 방을 다시 사용할 수 있다. => +10분 더 이용한다 생각
    // 끝나는 시간으로 정렬을 하고 가장 많이 겹치는 수가 필요한 방의 갯수 (그리디)
    public int solution(String[][] book_time) {
        PriorityQueue<방> pq = new PriorityQueue<>((a, b) -> {
            return a.s.compare(b.s);
        });
        
        for(String bt[]: book_time){
            String st[] = bt[0].split(":");
            String et[] = bt[1].split(":");
            
            시간 stt = new 시간(st[0], st[1]);
            시간 ett = new 시간(et[0], et[1]);
            ett.add(10);
            
            pq.offer(new 방(stt, ett));
        }
        
        // 방들 중에서 가장 많이 겹치는 갯수를 구한다
        // !시간이 똑같은건 겹치는게 아니다
       List<List<방>> rooms = new ArrayList<>();
        while(!pq.isEmpty()) {
            방 cur = pq.poll();
            
            if(rooms.isEmpty()) {
                rooms.add(new ArrayList<>());
            }
            
            boolean flag = true;
            start: for(List<방> room: rooms) {
                for(방 r: room) {
                    // 방이 겹치면
                    if(cur.x(r)) {
                        continue start;
                    }
                }
                
                room.add(cur);
                flag = false;
                break;
            }
            
            if(flag) {
                rooms.add(new ArrayList<>());
                rooms.get(rooms.size() - 1).add(cur);
            }
        }

        System.out.println(rooms);
        return rooms.size();
    }
}