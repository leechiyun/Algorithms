import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<char [][]> maps = new ArrayList<>();
	static char map[][];
	
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	
	static class Node{
		int x, y;
		int count;
		
		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", count=" + count + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		Node startNode = null;
		Node endNode = null;
		
		Queue<Node> waterQ = new ArrayDeque<>();
		boolean visited[][] = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				char c = input.charAt(j);
				if(c == 'S') {
					startNode = new Node(i, j, 0);
				} else if(c == 'D') {
					endNode = new Node(i, j, 0);
				} else if(c == '*') {
					waterQ.offer(new Node(i, j, 0));
					visited[i][j] = true;
				}
				
				map[i][j] = c;
			}
		}
		
		// 초기 map
		maps.add(copyMap(map));
		
		// 물 범람하는 것에 따른 map
		while(!waterQ.isEmpty()) {
			Node curNode = waterQ.poll();
			
			if(maps.size() <= curNode.count) {
				maps.add(copyMap(map));
			}
			
			for(int d = 0; d < dx.length; d++) {
				int nextX = curNode.x + dx[d];
				int nextY = curNode.y + dy[d];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M
						|| visited[nextX][nextY])
					continue;
				
				if(map[nextX][nextY] == '.' || map[nextX][nextY] == 'S') {
					map[nextX][nextY] = '*';
					visited[nextX][nextY] = true;
					waterQ.offer(new Node(nextX, nextY, curNode.count + 1));
				}
			}
		}
		
//		for(char[][] m: maps) {
//			printMap(m);
//		}
		
		// 고슴도치 도망가기
		visited = new boolean[N][M];
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(startNode);
		visited[startNode.x][startNode.y] = true;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			int idx = curNode.count >= maps.size() ? maps.size() - 1: curNode.count;
			
			// 갔지만 다음에 물에 빠졌으면, 못가는 곳
			if(maps.get(idx)[curNode.x][curNode.y] =='*') {
				continue;
			}
			
			if(curNode.x == endNode.x && curNode.y == endNode.y) {
				System.out.println(curNode.count);
				return;
			}
			
			for(int d = 0; d < dx.length; d++) {
				int nextX = curNode.x + dx[d];
				int nextY = curNode.y + dy[d];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M
						|| visited[nextX][nextY])
					continue;
				
				if(maps.get(idx)[nextX][nextY] != 'X' && maps.get(idx)[nextX][nextY] != '*') {
					visited[nextX][nextY] = true;
					queue.offer(new Node(nextX, nextY, curNode.count + 1));
				}
			}
		}
		
		System.out.println("KAKTUS");
		return;
	}
	
	public static void printMap(char[][] map) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static char[][] copyMap(char[][] map) {
		char[][] newMap = new char[map.length][map[0].length];
		
		for(int i = 0; i < map.length; i++) {
			newMap[i] = Arrays.copyOf(map[i], map[i].length);
		}
		
		return newMap;
	}
}