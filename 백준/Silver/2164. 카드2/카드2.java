import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <=N; i++) {
            queue.add(i);
        }

        // 문제 알고리즘
        while (queue.size() > 1){
            queue.poll();
            int n = queue.poll();
            queue.add(n);
        }

        System.out.println(queue.poll());
    }
}