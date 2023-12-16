import java.util.*;

class Solution {
    static class Node {
        int diamond;
        int iron;
        int stone;
        int result = 0;
        
        public Node(int diamond, int iron, int stone, int result) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
            this.result = result;
        }
        
        public int calculateTotalPicks() {
            int count = 0;
            
            count = this.diamond + this.iron + this.stone;
            
            return count;
        }
    }
    static String[] minerals;
    static List<Integer> results = new ArrayList<>();
    
    public int solution(int[] picks, String[] minerals) {
        this.minerals = minerals;
        Node startNode = new Node(picks[0], picks[1], picks[2], 0);
        
        dfs(startNode, 0);
        
        return Collections.min(results);
    }
    
    public int calculateMineral(String pick, String mineral) {
        if(pick.equals("diamond")) {
            return 1;
        }
        if(pick.equals("iron")) {
            if(mineral.equals("diamond")) {
                return 5;
            } else {
                return 1;
            }
        }
        if(pick.equals("stone")) {
            if(mineral.equals("diamond")) {
                return 25;
            } else if(mineral.equals("iron")) {
                return 5;
            } else {
                return 1;
            }
        }
        return -1;
    }
    
    private void dfs(Node node, int idx) {
        if(minerals.length <= idx * 5 || node.calculateTotalPicks() == 0) {
            results.add(node.result);
            return;
        }
        
        int count = 0;
        if(node.diamond > 0) {
            for(int i = idx * 5; i < minerals.length && i < idx * 5 + 5; i++) {
                count += 1;
            }
            dfs(new Node(node.diamond - 1, node.iron, node.stone, node.result + count), idx + 1);
        }
        
        count = 0;
        if(node.iron > 0) {
            for(int i = idx * 5; i < minerals.length && i < idx * 5 + 5; i++) {
                String mineral = minerals[i];
                count += calculateMineral("iron", mineral);
            }
            dfs(new Node(node.diamond, node.iron - 1, node.stone, node.result + count), idx + 1);
        }
        
        count = 0;
        if(node.stone > 0) {
            for(int i = idx * 5; i < minerals.length && i < idx * 5 + 5; i++) {
                String mineral = minerals[i];
                count += calculateMineral("stone", mineral);
            }
            dfs(new Node(node.diamond, node.iron, node.stone - 1, node.result + count), idx + 1);
        }
    }
}