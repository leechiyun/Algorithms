class Solution {
    public int solution(int[] numbers) {
        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum += i;
        }
        
        int totalNumber = 0;
        for(int number: numbers) {
            totalNumber += number;
        }
        return sum - totalNumber;
    }
}