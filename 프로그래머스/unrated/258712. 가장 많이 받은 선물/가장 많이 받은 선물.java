import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 1. 더 많은 선물을 준 사람이 다음 달 선물 하나 받음
        // 2. 선물을 주고받은 기록 X, 주고 받은 수 같은 경우
        //    선물 지수가 더 큰 사람이 작은 사람에게 선물을 하나 받음
        //      선물 지수가 같다면, 다음 달 선물 주고받지 않음
        Map<String, Integer> gives = new HashMap<>();
        Map<String, Integer> receives = new HashMap<>();
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            map.put(friends[i], new HashMap<>());
            gives.put(friends[i], 0);
            receives.put(friends[i], 0);
        }
        
        for(String gift: gifts) {
            StringTokenizer st = new StringTokenizer(gift, " ");
            String give = st.nextToken();
            String receive = st.nextToken();
            
            Map<String, Integer> newMap = map.get(give);
            newMap.put(receive, newMap.getOrDefault(receive, 0) + 1);
            map.put(give, newMap);
            
            gives.put(give, gives.getOrDefault(give, 0) + 1);
            receives.put(receive, receives.getOrDefault(receive, 0) + 1);
        }
        
        List<Integer> results = new ArrayList<>();
        for(String friend: friends) {
            int sum = 0;
            for(String opponent: friends) {
                if(!friend.equals(opponent)) {
                    if(map.get(friend).getOrDefault(opponent, 0) > map.get(opponent).getOrDefault(friend, 0)){
                        sum++;
                    } else if (map.get(friend).getOrDefault(opponent, 0) == 
                               map.get(opponent).getOrDefault(friend, 0)) {
                        int friendNum = gives.getOrDefault(friend, 0) - receives.getOrDefault(friend, 0);
                        int opponentNum = gives.getOrDefault(opponent, 0) - receives.getOrDefault(opponent, 0);
                        
                        if(friendNum > opponentNum) {
                            sum++;
                        }
                    }
                }
            }
            results.add(sum);
        }
        
        return Collections.max(results);
    }
}