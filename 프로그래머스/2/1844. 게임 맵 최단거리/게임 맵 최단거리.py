def solution(maps):
    N, M = len(maps), len(maps[0])
    
    q = [(0, 0, 1)]
    visited = [[False] * M for _ in range(N)]
    visited[0][0] = True
    
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    while q:
        x, y, cnt = q.pop(0)
        
        if x == N - 1 and y == M - 1:
            return cnt
        
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            
            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and maps[nx][ny] == 1:
                visited[nx][ny] = True
                q.append((nx, ny, cnt + 1))
    
    return -1