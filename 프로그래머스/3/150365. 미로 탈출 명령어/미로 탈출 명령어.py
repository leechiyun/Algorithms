def solution(n, m, x, y, r, c, k):
    """
    n x m 격자에서 (x,y)에서 (r,c)로 정확히 k번 이동
    사전순으로 가장 빠른 경로 반환
    """
    
    # 맨해튼 거리 계산
    def manhattan_distance(y1, x1, y2, x2):
        return abs(y1 - y2) + abs(x1 - x2)
    
    # 현재 위치에서 목적지까지 남은 거리로 도달 가능한지 확인
    def can_reach(cy, cx, remain):
        dist = manhattan_distance(cy, cx, r, c)
        # 남은 이동 횟수가 최단거리보다 크거나 같고
        # 차이가 짝수여야 함 (왔다갔다 가능)
        return remain >= dist and (remain - dist) % 2 == 0
    
    # 초기 불가능 판단
    min_dist = manhattan_distance(x, y, r, c)
    if k < min_dist or (k - min_dist) % 2 == 1:
        return "impossible"
    
    # 방향: d(하), l(좌), r(우), u(상) - 사전순
    directions = {
        'd': (1, 0),   # 아래
        'l': (0, -1),  # 왼쪽
        'r': (0, 1),   # 오른쪽
        'u': (-1, 0)   # 위
    }
    
    result = []
    cy, cx = x, y  # 현재 위치
    
    # k번 이동
    for step in range(k):
        remain = k - step - 1  # 이번 이동 후 남은 이동 횟수
        
        # 사전순으로 방향 시도 (d, l, r, u)
        for direction in ['d', 'l', 'r', 'u']:
            dy, dx = directions[direction]
            ny, nx = cy + dy, cx + dx
            
            # 격자 범위 체크
            if ny < 1 or ny > n or nx < 1 or nx > m:
                continue
            
            # 이 방향으로 가도 목적지에 도달 가능한지 확인
            if can_reach(ny, nx, remain):
                result.append(direction)
                cy, cx = ny, nx
                break
    
    return ''.join(result)