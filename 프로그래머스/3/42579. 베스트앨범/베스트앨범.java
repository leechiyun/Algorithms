import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> genreList = new ArrayList<>();
        for(String key: map.keySet()) {
            genreList.add(key);
        }
        
        Collections.sort(genreList, (a, b) -> map.get(b) - map.get(a));
        
        List<Integer> results = new ArrayList<>();
        for(String genre: genreList) {
            // 장르의 playList 구현
            Map<Integer, Integer> playMap = new HashMap<>();
            List<Integer> playList = new ArrayList<>();
            for(int i = 0; i < plays.length; i++) {
                if(genres[i].equals(genre)) {
                    playList.add(i);
                }
            }
            
            Collections.sort(playList, (a, b) -> {
                if(plays[a] == plays[b]) {
                    return a - b;
                }
                return plays[b] - plays[a];
            });
            
            // 2개 까지만
            results.add(playList.get(0));
            if(playList.size() >= 2) {
                results.add(playList.get(1));
            }
        }
        
        int[] answer = new int[results.size()];
        for(int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }
}