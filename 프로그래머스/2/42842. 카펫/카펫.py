def solution(brown, yellow):
    # 가로: n, 세로: m
    # n >= m
    answer = []
    n, m = 0, 0
    
    # T : 전체 카펫크기
    T = brown + yellow
    for y_m in range(1, yellow + 1):
        y_n = yellow // y_m
        if(y_n * y_m != yellow):
            continue
        
        if y_n < y_m:
            break
        
        # 테두리 한줄은 갈색으로 칠해져 있음
        n = y_n + 2
        m = y_m + 2
        
        if n * m == T:
            answer = [n, m]
            break
    
    return answer