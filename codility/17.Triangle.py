def solution(A):
    # Implement your solution here
    _a = sorted(A)
    for i in range(len(A)-2): 

        if _a[i] + _a[i+1] > _a[i+2]:
                return 1 

    return 0