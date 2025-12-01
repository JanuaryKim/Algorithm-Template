

J, N = map(int, input().split())

result = 0

Q = []

for i in range(0, N):
    tempQ = input()
    Q.append(tempQ)

for i in Q:
    tempSum = 0
    for j in range(0, len(i)):

        if i[j].isupper():
            tempSum += 4
        elif i[j].islower() or i[j].isdigit():
            tempSum += 2
        else:
            tempSum += 1
    if tempSum <= J:
        result += 1

print(result)