import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;



public class Main {
    static class Node implements Comparable<Node>{
        int end, weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node node){
            return this.weight - node.weight;
        }
    }

    static List<Node> list[];
    static boolean visited[];
    static int dist[];
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // V: 정점의 갯수, E: 간선의 갯수
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());
        visited = new boolean[V+1];
        dist = new int[V+1];
        Arrays.fill(dist, INF);

        // 그래프 연결리스트
        list = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());

            Node node = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            list[x].add(node);
        }

        // 다익스트라 알고리즘
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        dist[start] = 0;
        while (!queue.isEmpty()){
            Node curNode = queue.poll();
            int cur = curNode.end;

            if(!visited[cur]){
                visited[cur] = true;

                for(Node node: list[cur]){
                    // 최단 거리 구하기
                    if(!visited[node.end] && dist[node.end] > dist[cur] + node.weight){
                        dist[node.end] = dist[cur] + node.weight;
                        queue.add(new Node(node.end, dist[node.end]));
                    }
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if(dist[i] != INF){
                sb.append(dist[i]);
            }
            else {
                sb.append("INF");
            }

            if(i < V){
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}

