import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 카드를 2개 묶어서 정렬하고, 작은 것부터 다시 묶고 정렬하는 것이 값이 가장 적다
        Queue<Integer> cards = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            cards.offer(Integer.parseInt(br.readLine()));
        }



        int result = 0;
        while (cards.size() > 1) {
                // 1. 작은 카드 두개를 묶는다.
                int sumCard = cards.poll() + cards.poll();
                result += sumCard;

                // 2. 큐에 합친 카드를 다시 집어 넣는다
                cards.offer(sumCard);

        }
        System.out.println(result);
    }
}