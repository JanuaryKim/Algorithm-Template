
def solution():
    n = int(input())
    resultList = []
    for i in range(0, n):
        pw = input()
        if len(pw) >= 6 and len(pw) <= 9:
            resultList.append("yes")
        else:
            resultList.append("no")

    result = "\n".join(resultList)

    print(result)


solution()