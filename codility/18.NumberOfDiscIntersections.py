# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    
    # left and right boundary of each disk
    # any part out of the [0, len(A)-1] is meaningless, disc will have intersection within the [0, len(A)-1] range. 
    start = [0] * len(A) # how many disks start at i 
    end = [0] * len(A) # how many disks end at i
    
    for i in range(len(A)):
        left = max(0, i - A[i])
        right = min(len(A)-1, i + A[i])
        start[left] += 1
        end[right] += 1
    sum = 0
    in_middle = 0 # how many disks is already started but not ended at i. 
    for i in range(len(A)):
        # for all discs start at i, the intersection should be start[i] * (start[i] - 1) / 2
        sum += start[i] * (start[i] - 1) / 2
        # for part of the disc start at i, and the other part is not 
        sum += in_middle * start[i]
        in_middle += start[i] - end[i]
        if sum > 10000000:
            return -1
    return sum
        
    
    
    

    
    

def solution_E(A):
    disc = []
    for i in range(len(A)):
        disc.append([i - A[i], i + A[i]])
    _disc = sorted(disc) 
    # Set A is the bottom disc, B is the top disc
    bottom = 0
    top = len(A) - 1
    res = 0
    while bottom < top:
        if _disc[bottom][1] >= _disc[top][0]:
            res += top - bottom 
            if res > 10000000:
                return -1
            bottom += 1
            top = len(A) - 1
        else:
            top -= 1
    return res 
        
        

def solution_T(A):
    # Implement your solution here
    # each disk can be represent as [left, right]
    disc = []
    for i in range(len(A)):
        disc.append([i - A[i], i + A[i]])
    _disc = sorted(disc) 
    # print(_disc)
    res = 0
    for i in range(len(A)): 
        for j in range(i+1, len(A)): 
            # = means one point in common
            if _disc[j][0] <= _disc[i][1]:
                res += 1
                if res > 10000000:
                    return -1
    return res