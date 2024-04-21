import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }

        public boolean checkConnect(Pos other) {
            return Math.abs(other.x - this.x) <= 2 && Math.abs(other.y - this.y) <= 2;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static int N, T;
    static List<Pos> poss;
    static List<Integer> graphs[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        poss = new ArrayList<>();
        poss.add(new Pos(0, 0));
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            poss.add(new Pos(x, y));
        }

//        graphs = new List[N + 1];
//        for (int i = 0; i <= N; i++) {
//            graphs[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i <= N; i++) {
//            for (int j = i + 1; j <= N; j++) {
//                if(poss.get(i).checkConnect(poss.get(j))) {
//                    graphs[i].add(j);
//                    graphs[j].add(i);
//                }
//            }
//        }
        // 시간초과 해결법
        // 정렬 후 자신과 가까운 부분부터 검색하고, 조건이 맞지 않으면 다음 노드 확인
        Collections.sort(poss, (a, b) -> {
            if(a.y == b.y) {
                return Integer.compare(a.x, b.x);
            }
            return Integer.compare(a.y, b.y);
        });

        // BFS
        Queue<Node> queue = new ArrayDeque<>();
        boolean visited[] = new boolean[N + 1];
        visited[0] = true;
        queue.offer(new Node(0, 0));

        int result = -1;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            Pos curPos = poss.get(curNode.num);

            // 정상 도달
            if(curPos.y == T) {
                result = curNode.count;
                break;
            }

            // 다음 노드 검색
            // 1. 왼쪽
            for (int next = curNode.num - 1; next > 0; next--) {
                if(visited[next])
                    continue;

                // y축을 기준으로 정렬했기에 조건에 맞지 않으면 break
                if(Math.abs(curPos.y - poss.get(next).y) > 2)
                    break;

                if(Math.abs(curPos.x - poss.get(next).x) > 2)
                    continue;

                visited[next] = true;
                queue.offer(new Node(next, curNode.count + 1));
            }

            // 2. 오른쪽
            for (int next = curNode.num + 1; next <= N; next++) {
                if(visited[next])
                    continue;

                // y축을 기준으로 정렬했기에 조건에 맞지 않으면 break
                if(Math.abs(curPos.y - poss.get(next).y) > 2)
                    break;

                if(Math.abs(curPos.x - poss.get(next).x) > 2)
                    continue;

                visited[next] = true;
                queue.offer(new Node(next, curNode.count + 1));
            }

        }

        System.out.println(result);
    }
}