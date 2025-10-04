# N/2 가져가도 좋다
def solution(nums):
    
    N = len(nums)
    map = dict.fromkeys(nums, 0)
    for n in nums:
        map[n] += 1
    
    if len(map.keys()) > N // 2:
        return N // 2
    
    return len(map.keys())