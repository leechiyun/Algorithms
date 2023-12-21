import java.util.*;

class Solution {
    static List<int[]> dungeonList = new ArrayList<>();
    static List<Integer> results = new ArrayList<>();
    
    public int solution(int k, int[][] dungeons) {
        for(int[] dungeon: dungeons) {
            dungeonList.add(dungeon);
        }
        
        dfs(dungeonList, k, 0);
        
        return Collections.max(results);
    }
    
    private void dfs(List<int[]> dungeonList, int k, int count) {
        if(dungeonList.size() == 0) {
            results.add(count);
            return;
        }
        
        for(int i = 0; i < dungeonList.size(); i++) {
            int[] dungeon = dungeonList.get(i);
            
            List<int[]> newDungeons = new ArrayList<>();
            for(int j = 0; j < dungeonList.size(); j++) {
                if(i != j) {
                    newDungeons.add(dungeonList.get(j));
                }
            }
            
            if(k >= dungeon[0]) {
                dfs(newDungeons, k - dungeon[1], count + 1);
            } else {
                dfs(newDungeons, k, count);
            }
        }
    }
}