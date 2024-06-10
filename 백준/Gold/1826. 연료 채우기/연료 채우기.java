import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static class 주유소 {
        int a, b;

        public 주유소(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "주유소{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    // 1. 해당 연료를 먹거나 안먹거나 하여 도착가능한 최저 주유소 수를 구한다(부분집합) => O(2^n) => 2^10000 (X)
    // 2. 연료가 부족한 경우 거리 안에 들면서 가장 많이 채울 수 있는 주유소를 선택하여 간다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        // 거리가 가장 가까운 것부터 검색하여, 그 중 많이 채울 수 있는 주유소를 선택
        PriorityQueue<주유소> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.a, b.a);
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            pq.offer(new 주유소(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // 갈 수 있는 최대 거리
        st = new StringTokenizer(br.readLine());
        int end = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());


        // P 보다 작은 거리 중에서 가장 큰 주유량을 가진 주유소만 선택
        PriorityQueue<주유소> maxPq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b.b, a.b);
        });
        int result = 0;
        while(P < end) {
            while(!pq.isEmpty()) {
                주유소 cur = pq.poll();

                if(cur.a > P) {
                    pq.offer(cur);
                    break;
                }

                maxPq.offer(cur);
            }

            if(maxPq.isEmpty()) {
                System.out.println(-1);
                return;
            }
            P += maxPq.poll().b;
            result++;
        }

        System.out.println(result);
    }
}