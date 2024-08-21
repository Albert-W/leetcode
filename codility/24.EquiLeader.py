# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # Implement your solution here
    # Finder the majority number m 
    count = 1
    m = A[0]
    for i in A[1:]:
        if i == m: 
            count += 1
        else: 
            count -= 1
            if count == 0:
                m = i
                count = 1
    total = A.count(m)
    if total < len(A) / 2:
        return 0 
    res = 0
    count = 0
    for i in range(len(A)):
        if A[i] == m:
            count += 1
        # Each i is a potential split point.
        if count > (i+1)/2 and (total - count) > (len(A) - i - 1)/2:
            # print(i)
            res += 1
    return res