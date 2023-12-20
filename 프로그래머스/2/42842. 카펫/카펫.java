class Solution {
    public int[] solution(int brown, int yellow) {
        int size = brown + yellow;
        
        // x: 가로, y: 세로
        int x = 0;
        int y = 0;
        
        // y는 적어도 2보다 커야 yellow가 들어갈 공간이 생김
        for(int i = 3; i < size; i++) {
            y = i;
            if(size % y == 0) {
                x = size / y;
                
                int yellowSize = (x - 2) * (y - 2);
                if(yellowSize == yellow) {
                    break;
                }
            }
        }
        
        int[] answer = {x, y};
        return answer;
    }
}