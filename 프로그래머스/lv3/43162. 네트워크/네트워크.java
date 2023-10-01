import java.util.*;

class Solution {
    static List<Integer> list[];
    static boolean visited[];

    public int solution(int n, int[][] computers) {
        list = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (computers[i][j] == 1) {
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }

        // bfs
        Queue<Integer> queue = new ArrayDeque<>();
        int reusult = 0;
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                queue.offer(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int node = queue.poll();

                    for (int next : list[node]) {
                        if (!visited[next]) {
                            queue.offer(next);
                            visited[next] = true;
                        }
                    }
                }

                reusult++;
            }
        }

        return reusult;
    }
}