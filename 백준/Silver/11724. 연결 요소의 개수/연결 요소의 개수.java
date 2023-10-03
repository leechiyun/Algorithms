import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static List<Integer> list[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 그래프 연결 리스트 추가
            list[a].add(b);
            list[b].add(a);
        }

        // bfs 로 그래프 순회하며 연결 컴포넌트 찾기
        Queue<Integer> queue = new ArrayDeque<>();

        int result = 0;
        // 연결 지점 찾기
        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                // 시작 지점
                queue.offer(i);
                visited[i] = true;

                while (!queue.isEmpty()){
                    int node = queue.poll();;

                    for(int next: list[node]){
                        if(!visited[next]){
                            queue.offer(next);
                            visited[next] = true;
                        }
                    }
                }
                result++;
            }

        }

        System.out.println(result);
    }
}

