from collections import defaultdict

def solution(today, terms, privacies):
    answer = []
    
    td = dict()
    for t in terms:
        k, v = t.split(" ")
        td[k] = int(v)

    # 모든 달은 28일
    def calF(date, mm):
        y, m, d = date.split(".")
        y = int(y)
        m = int(m)
        d = int(d)
        
        d -= 1
        while d <= 0:
            m -= 1
            d += 28
        
        m += mm
        while m > 12:
            m -= 12
            y += 1
        
        y = str(y)
        m = str(m)
        d = str(d)
        
        if int(d) < 10:
            d = "0" + d
        
        if int(m) < 10:
            m = "0" + m
            
        return y + "." + m  + "." + d
    
    for i in range(len(privacies)):
        date, k = privacies[i].split(" ")
        
        if calF(date, td[k]) < today:
            answer.append(i + 1)
    
    return answer