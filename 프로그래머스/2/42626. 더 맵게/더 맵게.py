import heapq

def solution(scoville, K):
    answer = 0
    
    heapq.heapify(scoville)
    
    while scoville[0] < K:  # 가장 작은 값이 K보다 작으면 계속
        if len(scoville) < 2:  # 섞을 음식이 없으면 실패
            return -1
        
        s1 = heapq.heappop(scoville)
        s2 = heapq.heappop(scoville)
        
        newS = s1 + (s2 * 2)
        heapq.heappush(scoville, newS)
        answer += 1
    
    return answer