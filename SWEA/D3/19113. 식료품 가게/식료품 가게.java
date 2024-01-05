import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
        	int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N*2];
            Map<Integer, Integer> map = new HashMap<>();
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i =0; i<N*2; i++){
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            
            List<Integer> results = new ArrayList<>();
            for(int originalNumber: arr) {
                int saleNumber = (originalNumber / 4) * 3;
                
                // 할인 안된 가격이 존재하면
                if(map.getOrDefault(saleNumber, 0) > 0){
                    results.add(saleNumber);
                    
                    map.put(saleNumber, map.getOrDefault(saleNumber, 0) - 1);
                    map.put(originalNumber, map.getOrDefault(originalNumber, 0) - 1);
                }
                
                // 삭제 로직
               	if(map.getOrDefault(saleNumber, 0) <= 0){
                    map.remove(saleNumber);
                }
                if(map.getOrDefault(originalNumber, 0) <= 0){
                    map.remove(originalNumber);
                }
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
            for(int result: results) {
                sb.append(result).append(" ");
            }
            System.out.println(sb);
        }
	}
}