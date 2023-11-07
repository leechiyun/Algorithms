import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int dx[] = new int[] {-2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = 10;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= tc; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int count = View(list);
            sb.append("#").append(i).append(" ");
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static int View(List<Integer> list) {
        int count = 0;
        for (int j = 0; j < list.size(); j++) {
            int centerHeight = list.get(j);
            int x = j;
            int max = 0;

            boolean check = true;
            for (int k = 0; k < dx.length; k++) {
                int nextX = x + dx[k];

                if(nextX >= 0 && nextX < list.size()) {
                    if(list.get(nextX) < centerHeight) {
                        if (max < list.get(nextX)) {
                            max = list.get(nextX);
                        }
                    } else {
                        check = false;
                        break;
                    }
                }
            }

            if (check) {
                count += centerHeight - max;
            }
        }
        return count;
    }
}
