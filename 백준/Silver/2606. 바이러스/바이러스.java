import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<Integer>[] map;
    static boolean visited[];
    static int N, M;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        // ArrayList 초기화
        map = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        
        // map 입력 (그래프)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 값 집어넣기
            map[x].add(y);
            map[y].add(x);
        }

        // bfs
        // 1. Queue 에 시작점 넣게
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()){
            int pos = queue.poll();

            for (int i = 0; i < map[pos].size(); i++) {
                if(!visited[map[pos].get(i)]){
                    queue.offer(map[pos].get(i));
                    visited[map[pos].get(i)] = true;
                    count++;
                }

            }
        }
        System.out.println(count);
    }
}