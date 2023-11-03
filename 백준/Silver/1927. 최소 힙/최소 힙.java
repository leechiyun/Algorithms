import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            Long n = Long.parseLong(br.readLine());

            if (n == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(priorityQueue.poll());
                }
                sb.append("\n");
            } else if (n > 0) {
                priorityQueue.offer(n);
            }
        }

        System.out.println(sb);
    }
}
