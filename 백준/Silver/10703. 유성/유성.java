import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class C {
        List<Node> nodes;

        public C(List<Node> nodes) {
            this.nodes = nodes;
        }

        // 아래로 한칸씩 낙하
        public void down() {
            for(Node node: nodes) {
                node.x++;
            }
        }
        // 아래로 한칸씩 낙하
        public void down(int n) {
            for(Node node: nodes) {
                node.x += n;
            }
        }

        public void up() {
            for(Node node: nodes) {
                node.x--;
            }
        }

        public boolean crush() {
            if(this.nodes.isEmpty())
                return false;

            for(Node node: nodes) {
                if(map[node.x][node.y] == '#')
                    return true;
            }

            return false;
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return this.x + " " + this.y;
        }
    }

    static int N, M;
    static char map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        char cMap[][] = new char[N][M];     // 초기 맵
        // 땅의 위치 저장
        C comet = new C(new ArrayList<>());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);

                if(c == 'X') {
                    comet.nodes.add(new Node(i, j));
                    map[i][j] = '.';
                }
                else {
                    map[i][j] = c;
                }
                cMap[i][j] = c;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            int cnt = 0;
            boolean flag = false;
            for (int i = N - 1; i >= 0; i--) {
                if(flag && cMap[i][j] == 'X') {
                    min = Math.min(min, cnt);
                    flag = false;
                }

                if(cMap[i][j] == '.') {
                    cnt++;
                }

                if(cMap[i][j] == '#') {
                    cnt = 0;
                    flag = true;
                }
            }
        }

        comet.down(min);

        for (Node node: comet.nodes) {
            map[node.x][node.y] = 'X';
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}