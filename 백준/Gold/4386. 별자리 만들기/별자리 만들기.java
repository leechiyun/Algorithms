import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static double map[][];

    static class Star {
        double x, y;

        public Star (double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double calculateDistance(double x, double y){
            double absX = Math.abs(this.x - x);
            double absY = Math.abs(this.y - y);

            return Math.sqrt(Math.pow(absX, 2) + Math.pow(absY, 2));
        }

        public double calculateDistance(Star star){
            return calculateDistance(star.x, star.y);
        }
    }

    static class Vertex {
        int no;
        double weight;

        public Vertex(int no, double weight){
            this.no = no;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        List<Star> stars = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stars.add(new Star(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
        }


        map = new double[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = stars.get(i).calculateDistance(stars.get(j));
            }
        }

        // 인접행렬: 프림 알고리즘!
        double minEdge[] = new double[N];
        Arrays.fill(minEdge, Double.MAX_VALUE);

        // 정점 방문 처리
        boolean visited[] = new boolean[N];

        PriorityQueue<Vertex> pq = new PriorityQueue<>((a, b) -> Double.compare(a.weight, b.weight));
        pq.offer(new Vertex(0, 0));

        double result = 0;
        int cnt = 0;        // 연결 간선 수
        while (!pq.isEmpty()){
            Vertex minVertex = pq.poll();

            if(visited[minVertex.no]) {
                continue;
            }

            visited[minVertex.no] = true;
            result += minVertex.weight;
            cnt++;

            for(int i = 0; i < N; i++) {
                if(!visited[i] && map[minVertex.no][i] != 0
                && minEdge[i] > map[minVertex.no][i]) {
                    minEdge[i] = map[minVertex.no][i];
                    pq.offer(new Vertex(i, minEdge[i]));
                }
            }
        }

        System.out.println(cnt == N ? String.format("%.2f", result) : -1);
    }
}