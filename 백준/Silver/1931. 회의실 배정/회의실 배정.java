import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Room{
        Long start;
        Long end;

        Room(Long start, Long end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Start: " + start + "End: " + end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Room> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Long x = Long.parseLong(st.nextToken());
            Long y = Long.parseLong(st.nextToken());

            list.add(new Room(x, y));
        }


        Collections.sort(list, (r1, r2) -> {
            if(r1.end == r2.end){
                return (int)(r1.start - r2.start);
            }
            return (int)(r1.end - r2.end);
        });
        Long compareNum = 0L;
        int count = 0;
        for(Room cur: list){
            if(cur.start >= compareNum){
                compareNum = cur.end;
                count++;
            }
        }

        System.out.println(count);
    }
}

