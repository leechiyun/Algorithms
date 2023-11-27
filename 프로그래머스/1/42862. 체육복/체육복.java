import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Map<Integer, Integer> member = new HashMap<>();
        for(int i = 1; i <= n; i++){
            member.put(i, 1);
        }

        // 여벌 체육복이 있는 학생
        for(int reserveMember: reserve) {
            member.put(reserveMember, member.get(reserveMember) + 1);
        }

        // 체육복 도난 당한 학생
        for(int lostMember: lost) {
            member.put(lostMember, member.get(lostMember) - 1);
        }
        
        for(int memberNumber: member.keySet()) {
            System.out.println(member.get(memberNumber));
        }
        
        Arrays.sort(lost);

        // 체육복이 없는 학생 빌려주는 로직
        for (int lostMember: lost) {
            // 앞 번호 학생이 남는 체육복이 있는지 확인
            if(member.get(lostMember) == 0 && member.getOrDefault(lostMember - 1, 0) > 1){
                member.put(lostMember, member.get(lostMember) + 1);
                member.put(lostMember - 1, member.get(lostMember - 1) - 1);

                continue;
            }

            // 뒷 번호 학생이 남는 체육복이 있는지 확인
            if(member.get(lostMember) == 0 && member.getOrDefault(lostMember + 1, 0) > 1){
                member.put(lostMember, member.get(lostMember) + 1);
                member.put(lostMember + 1, member.get(lostMember + 1) - 1);
            }
        }

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(member.getOrDefault(i, 0) >= 1){
                answer++;
            }
        }
        
        return answer;
    }
}