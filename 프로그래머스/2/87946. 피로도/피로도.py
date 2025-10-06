def solution(k, dungeons):
    answer = -1
    
    N = len(dungeons)
    
    # p: 남은 피로도
    def dfs(p, cnt):
        nonlocal answer
        answer = max(answer, cnt)
        
        for i in range(N):
            if visited[i]:
                continue

            # cp: 최소 필요 피로도, sp: 소모 피로도
            cp, sp = dungeons[i]
            if cp > p:
                continue;

            visited[i] = True
            dfs(p - sp, cnt + 1)
            visited[i] = False
            
    for i in range(N):
        visited = [False] * N
        dfs(k, 0)
    
    return answer