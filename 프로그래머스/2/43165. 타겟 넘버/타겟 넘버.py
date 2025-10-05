def solution(numbers, target):
    answer = 0
    N = len(numbers)
    
    def dfs(idx, result):
        nonlocal answer
        
        if idx == N:
            if target == result:
                answer += 1
            return
        
        dfs(idx + 1, result + numbers[idx])
        dfs(idx + 1, result - numbers[idx])
    
    dfs(0, 0)
    return answer