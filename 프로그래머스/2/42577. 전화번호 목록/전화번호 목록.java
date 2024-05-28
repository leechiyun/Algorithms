import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        Set<Integer> lenSet = new HashSet<>();
        for(String phone: phone_book) {
            map.put(phone, phone.length());
            lenSet.add(phone.length());
        }
        
        // 확인
        for(String phone: phone_book) {
            for(int len: lenSet) {
                if(len < phone.length()) {
                    String str = phone.substring(0, len);
                    
                    if(map.containsKey(str)){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}