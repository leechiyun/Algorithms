import java.util.*;

class Solution {
    static Map<String, List> map = new HashMap<>();
    static Map<String, Boolean> visited = new HashMap<>();
    static List<Integer> results = new ArrayList<>();
    
    static class Node {
        String name;
        int count;
        
        Node(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        for(String word: words) {
            List<String> list = new ArrayList<>();
            for(String compareWord: words) {
                if(word.length() - 1 == calculateSameWord(word, compareWord)) {
                    list.add(compareWord);
                }
            }
            
            map.put(word, list);
            visited.put(word, false);
        }
        
        Queue<Node> queue = new ArrayDeque<>();
        visited.put(begin, true);
        for(String compareWord: words) {
            if(begin.length() - 1 == calculateSameWord(begin, compareWord)) {
                queue.offer(new Node(compareWord, 1));
            }
        }
        
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            if(curNode.name.equals(target)){
                results.add(curNode.count);
            }
            
            List<String> list = map.getOrDefault(curNode.name, Collections.emptyList());
            for(String nextWord: list) {
                if(!visited.get(nextWord)){
                    queue.offer(new Node(nextWord, curNode.count + 1));
                    visited.put(nextWord, true);
                }
            }
        }
        
        if(results.isEmpty()){
            return 0;
        }
        return Collections.min(results);
    }
    
    private static int calculateSameWord(String word, String compare) {
        int count = 0;
        
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == compare.charAt(i)) {
                count++;
            }
        }
        
        return count;
    }
}