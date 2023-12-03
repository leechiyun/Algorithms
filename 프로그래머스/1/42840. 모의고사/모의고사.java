import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        List<Integer> listC = new ArrayList<>();
        
        // 1, 2, 3, 4, 5, ...
        for(int i = 0; i < answers.length; i++) {
            listA.add((i % 5) + 1);
        }
        
        // 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, ...
        for(int i = 0; i < answers.length; i++) {
            if(i % 2 == 0) {
                listB.add(2);
            } else {
                if((i / 2) % 4 == 0) {
                    listB.add((i / 2) % 4 + 1);
                } else {
                    listB.add((i / 2) % 4 + 2);
                }
            }
        }
        
        // 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
        int arr[] = new int[]{3, 1, 2, 4, 5};
        for(int i = 0; i < answers.length; i++) {
            listC.add(arr[(i / 2) % 5]);
        }
        
        Map<Integer, Integer> result = new HashMap<>();
        for(int i = 0; i < answers.length; i++) {
            int solution = answers[i];
            if(listA.get(i) == solution) {
                result.put(1, result.getOrDefault(1, 0) + 1);
            }
            if(listB.get(i) == solution) {
                result.put(2, result.getOrDefault(2, 0) + 1);
            }
            if(listC.get(i) == solution) {
                result.put(3, result.getOrDefault(3, 0) + 1);
            }
        }
        
        List<Integer> resultList = new ArrayList<>();
        int max = Collections.max(result.values());
        for(int key: result.keySet()) {
            if(result.get(key) == max) {
                resultList.add(key);
            }
        }
        
        int[] answer = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++){
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}