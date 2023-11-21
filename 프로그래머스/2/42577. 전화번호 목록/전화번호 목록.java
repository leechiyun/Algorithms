import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        for(String phone: phone_book) {
            map.put(phone, map.getOrDefault(phone, 0) + 1);
        }

        for(String phone: phone_book) {
            for(int i = 0; i < phone.length(); i++){
                if(map.containsKey(phone.substring(0, i))){
                    return false;
                }
            }
        }

        boolean answer = true;
        return answer;
    }
}