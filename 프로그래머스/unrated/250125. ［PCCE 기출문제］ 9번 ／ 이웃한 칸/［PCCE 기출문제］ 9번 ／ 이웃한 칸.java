class Solution {
    // 3. h와 w의 변화량을 저장할 정수 리스트 dh, dw를 만들고 각각 [0, 1, -1, 0], [1, 0, 0, -1]을 저장합니다.
    static int[] dx = new int[]{0, 1, -1, 0};
    static int[] dy = new int[]{1, 0, 0, -1};
    
    public int solution(String[][] board, int h, int w) {
        // 1. 정수를 저장할 변수 n을 만들고 board의 길이를 저장합니다.
        int N = board.length;
        
        // 2. 같은 색으로 색칠된 칸의 개수를 저장할 변수 count를 만들고 0을 저장합니다.
        int count = 0;
        
        // 4. 반복문을 이용해 i 값을 0부터 3까지 1 씩 증가시키며 아래 작업을 반복합니다.
        String centerColor = board[h][w];
        for(int i = 0; i < dx.length; i++) {
            // 4-1. 체크할 칸의 h, w 좌표를 나타내는 변수 h_check, w_check를 만들고, 
            // 각각 h + dh[i], w + dw[i]를 저장합니다.
            int nextX = h + dx[i];
            int nextY = w + dy[i];
            
            if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && centerColor.equals(board[nextX][nextY])){
                count++;
            }
        }
        
        return count;
    }
}