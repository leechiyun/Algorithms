import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int left = 0, right = list.size() - 1;
        int min = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                result.clear();
                result.add(list.get(left));
                result.add(list.get(right));
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(result.get(0) + " " + result.get(1));
    }
}