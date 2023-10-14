import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static boolean visited[];
    static class Node{
        int num;
        int count;

        public Node(int num, int count){
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        List<Integer> resultList = new ArrayList<>();

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(N, 0));
        visited[N] = true;
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            if(curNode.num == K){
                resultList.add(curNode.count);
            }

            // -1, +1, *2 : 3가지의 경우
            if(curNode.num-1 >= 0 && !visited[curNode.num-1]){
                queue.offer(new Node(curNode.num-1, curNode.count+1));
                visited[curNode.num-1] = true;
            }
            if(curNode.num+1 <= 100000 && !visited[curNode.num+1]){
                queue.offer(new Node(curNode.num+1, curNode.count+1));
                visited[curNode.num+1] = true;
            }
            if(curNode.num*2 <= 100000 && !visited[curNode.num*2]){
                queue.offer(new Node(curNode.num*2, curNode.count+1));
                visited[curNode.num*2] = true;
            }
        }

        System.out.println(Collections.min(resultList));
    }

}

