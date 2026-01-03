import sys

n = sys.stdin.readline()
arr = list(map(int, input().split()))

maxContinue = 0
tempContinue = 0
useSkillCnt = 1
preNum = arr[0]

for i in arr:
    if i < preNum:
        if tempContinue > maxContinue: maxContinue = tempContinue
        useSkillCnt += 1
        tempContinue = 1
    else:
        tempContinue += 1
    preNum = i

if tempContinue > maxContinue: maxContinue = tempContinue
print(str(useSkillCnt) + ' ' + str(maxContinue))