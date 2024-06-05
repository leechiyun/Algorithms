class Solution {
    public long solution(int r1, int r2) {      
        long sumY = 0;
        for(int x = 1; x < r2; x++) {
            long y1Cnt = (long)Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2));
            long y2Cnt = (long)Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2));
            
            // r1이 테두리에 겹칠 경우 -1
            if(Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2)) % 1 == 0 && x < r1) {
                y1Cnt--;
            }
            
            sumY += y2Cnt - y1Cnt;
        }
        
        long sub = r2 - r1 + 1;
        
        return (sumY + sub) * 4;
    }
    
}