J, N = map(int ,input().split())

cnt = 0

for i in range(0, N) : 
    A = input()
    
    sum = 0
    
    for j in range(0, len(A)) : 
        if A[j].isupper() : 
            sum += 4
        elif A[j].islower() or A[j].isdigit(): 
            sum += 2
        elif A[j] == ' ' : 
            sum += 1
    
    if J >= sum : 
        cnt += 1

print(cnt)