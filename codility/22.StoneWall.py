def solution(H):
    # 
    s = [] # a stack of the height with the potential to reduce blocks. 
    res = 0
    for b in H:

        # if the current block is lower the the stop of the stack. 
        while len(s) > 0 and b < s[-1]:
            s.pop()
            res += 1
        if len(s) == 0 or b > s[-1]:
            s.append(b)
            
        if b > s[-1]:
            s.append(b)
    return res + len(s)


def solution_E(H):
    # Implement your solution here
    _min = 0
    res = 1
    for i in range(1,len(H)): 
        # print(H[_min:i])
        if H[i] in H[_min:i]:
            continue
        else: 
            res += 1
            if H[i] < H[_min]:
                _min = i
        
    return res