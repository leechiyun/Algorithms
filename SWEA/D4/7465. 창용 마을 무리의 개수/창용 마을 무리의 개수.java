import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static int n,m,result;
    public static int[][] map;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //마을에 사는 사람의 수
            m = Integer.parseInt(st.nextToken()); //서로 알고 있는 사람의 수
            map = new int[n+1][n+1];
            visited = new boolean[n+1];

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[a][b] = 1;
                map[b][a] = 1;
            }

            result = 0;
            for(int i=1; i<=n; i++) {
                if(visited[i]) continue;
                bfs(i);
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for(int i=1; i<=n; i++) {
                if(visited[i]) continue; //이미 방문했으면 패스
                if(map[now][i] == 0) continue; //연결되어있지 않으면 패스

                //System.out.println(now + " -> " + i);
                queue.add(i);
                visited[i] = true;
            }
        }
        result++;
    }
}