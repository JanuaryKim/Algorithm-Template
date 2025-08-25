word_list = input().split()

check_duplicate = dict()
is_duplicate = False

for word in word_list:

    if word in check_duplicate:
        is_duplicate = True
        break
    
    check_duplicate[word] = 1

if is_duplicate:
    print('no')
else:
    print('yes')