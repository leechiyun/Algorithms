import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static boolean visited[];

    public static class Node {
        int pos;
        int count;

        public Node(int pos, int count) {
            this.pos = pos;
            this.count = count;
        }
    }

    static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[101];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map.put(x, y);
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if (curNode.pos == 100) {
                resultList.add(curNode.count);
            }

            for (int i = 6; i >= 1; i--) {
                int nextPos = curNode.pos + i;

                if (nextPos <= 100) {
                    if (map.get(nextPos) != null && !visited[nextPos]) {
                        queue.offer(new Node(map.get(nextPos), curNode.count + 1));
                        visited[nextPos] = true;
                    }
                    if(!visited[nextPos]){
                        queue.offer(new Node(nextPos, curNode.count + 1));
                        visited[nextPos] = true;
                    }

                }

            }
        }
        System.out.println(Collections.min(resultList));
    }
}

