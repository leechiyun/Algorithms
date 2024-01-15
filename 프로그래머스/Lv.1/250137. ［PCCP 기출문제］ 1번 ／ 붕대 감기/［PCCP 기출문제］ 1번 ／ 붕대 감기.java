class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 연속 성공
        int successCount = 0;
        int time = 0;
        int attackIndex = 0;
        int attackTime = attacks[attackIndex][0];
        int prevAttackTime = 0;
        int currentHealth = health;
        
        while(true) {
            // 공격 받음
            if(time == attackTime) {
                currentHealth -= attacks[attackIndex][1];
                attackIndex++;
                if(attackIndex >= attacks.length) {
                    if(currentHealth <= 0) {
                        return -1;
                    }
                    
                    return currentHealth;
                }
                
                prevAttackTime = attackTime;
                attackTime = attacks[attackIndex][0];
                successCount = 0;
            }
               
            // 초당 회복
            if(time != prevAttackTime && currentHealth < health) {
                currentHealth += bandage[1];
            }
            
            // 연속 성공
            if(time != prevAttackTime && successCount == bandage[0]) {
                currentHealth += bandage[2];
                successCount = 0;
            }
            
            // 회복량이 최대 체력을 넘지 않도록 함
            if(currentHealth >= health) {
                currentHealth = health;
            }
            
            // 체력이 0이하면 즉사
            if(currentHealth <= 0) {
                return -1;
            }

            time++;
            successCount++;
        }
    }
}