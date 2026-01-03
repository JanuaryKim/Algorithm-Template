def solution():
    n = int(input())
    resultList = []
    for i in range(1, n + 1):
        line = input()
        newLine = str(i) + ". " + line
        resultList.append(newLine)

    print("\n".join(resultList))
solution()