
def solution():
    time, alcohol = map(int, input().split())
    if alcohol == 1 or not (time >= 12 and time <= 16):
        print(280)
    else:
        print(320)

solution()