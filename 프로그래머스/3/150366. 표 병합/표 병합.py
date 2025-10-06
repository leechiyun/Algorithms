class UnionFind:
    def __init__(self, n, m):
        self.n = n
        self.m = m
        size = n * m
        self.parent = list(range(size))
        self.value = [None] * size  # 각 셀의 값 저장
    
    def find(self, x):
        """x의 루트 찾기 (경로 압축)"""
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self, x, y):
        """x와 y 병합"""
        root_x = self.find(x)
        root_y = self.find(y)
        
        if root_x != root_y:
            self.parent[root_y] = root_x
            # 값이 있는 쪽을 우선
            if self.value[root_x] is None and self.value[root_y] is not None:
                self.value[root_x] = self.value[root_y]
    
    def unmerge(self, x):
        """x가 속한 병합 해제"""
        root_x = self.find(x)
        original_value = self.value[root_x]
        
        # root_x와 같은 그룹의 모든 셀 찾기
        to_unmerge = []
        for i in range(len(self.parent)):
            if self.find(i) == root_x:
                to_unmerge.append(i)
        
        # 병합 해제
        for i in to_unmerge:
            self.parent[i] = i
            self.value[i] = None
        
        # 원래 위치에만 값 유지
        self.value[x] = original_value
    
    def update_value(self, x, val):
        """x의 값 업데이트 (병합된 경우 루트에 저장)"""
        root = self.find(x)
        self.value[root] = val
    
    def get_value(self, x):
        """x의 값 가져오기"""
        root = self.find(x)
        return self.value[root]


def solution(commands):
    answer = []
    
    N, M = 50, 50
    
    def get_idx(r, c):
        """(r, c) 좌표를 1차원 인덱스로 변환"""
        return r * M + c
    
    uf = UnionFind(N, M)
    
    for cmd_str in commands:
        parts = cmd_str.split()
        cmd = parts[0]
        
        if cmd == "UPDATE":
            if len(parts) == 4:  # UPDATE r c value
                r = int(parts[1]) - 1  # 1-based → 0-based
                c = int(parts[2]) - 1
                value = parts[3]
                
                idx = get_idx(r, c)
                uf.update_value(idx, value)
                
            else:  # UPDATE value1 value2 (모든 value1을 value2로)
                value1 = parts[1]
                value2 = parts[2]
                
                for i in range(N * M):
                    if uf.get_value(i) == value1:
                        uf.update_value(i, value2)
        
        elif cmd == "MERGE":
            r1 = int(parts[1]) - 1
            c1 = int(parts[2]) - 1
            r2 = int(parts[3]) - 1
            c2 = int(parts[4]) - 1
            
            idx1 = get_idx(r1, c1)
            idx2 = get_idx(r2, c2)
            
            # 이미 같은 그룹이면 무시
            if uf.find(idx1) != uf.find(idx2):
                uf.union(idx1, idx2)
        
        elif cmd == "UNMERGE":
            r = int(parts[1]) - 1
            c = int(parts[2]) - 1
            
            idx = get_idx(r, c)
            uf.unmerge(idx)
        
        elif cmd == "PRINT":
            r = int(parts[1]) - 1
            c = int(parts[2]) - 1
            
            idx = get_idx(r, c)
            value = uf.get_value(idx)
            
            answer.append(value if value is not None else "EMPTY")
    
    return answer