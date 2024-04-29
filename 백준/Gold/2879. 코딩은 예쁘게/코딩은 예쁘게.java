import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int arr[];
    static int originArr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        originArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            originArr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Queue<Integer>> results = new ArrayDeque<>();
        boolean flag = true;
        for(int i = 0; i < N; i++) {
            int n = originArr[i] - arr[i];

            if(n == 0) {
                results.offer(queue);
                queue = new ArrayDeque<>();
                continue;
            }

            if(flag) {
                if(n < 0) {
                    results.add(queue);
                    queue = new ArrayDeque<>();
                    flag = false;
                }
            } else {
                if(n > 0) {
                    results.add(queue);
                    queue = new ArrayDeque<>();
                    flag = true;
                }
            }

            queue.offer(n);
        }
        results.add(queue);

        // 그리디적 접근법
        int cnt = 0;
        while(!results.isEmpty()) {
            Queue<Integer> q = results.poll();

            while(!q.isEmpty()) {
                int size = q.size();
                Queue<Integer> tempQ = new ArrayDeque<>();
                for(int i = 0; i < size; i++) {
                    int n = q.poll();

                    if(n > 0) {
                        n--;
                    }
                    if(n < 0) {
                        n++;
                    }

                    if(n == 0 && !tempQ.isEmpty()) {
                        results.offer(tempQ);
                        tempQ = new ArrayDeque<>();
                    }

                    if(n != 0) {
                        tempQ.offer(n);
                    }
                }
                q = tempQ;

                cnt++;
            }
        }

        System.out.println(cnt);
    }

}