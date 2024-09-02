# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # Implement your solution here
    S = 0 # Sum of the abs version of A 
    M = 0 # Max of the abs version of A 
    count = {}
    for i in range(len(A)):
        A[i] = abs(A[i])
        S += A[i]
        M = max(M, A[i])
        if A[i] in count:
            count[A[i]] += 1
        else:    
            count[A[i]] = 1
    # print(count)
    # print(S, M)
    # The goal is to find possible sum of subarray which is closetest to S / 2 
    # dq[i] = 1 mean it's possilbe to reach i, dq[i] = 0 mean it's not possible
    dq = [0] * (S + 1 )
    dq[0] = 1 # count the first one
    for a in count:
        for i in range(S):
            if dq[i] >= 1 : # If it's possible to reach i, it stole the number of count[a] + 1
                # update [i + a] will change the future i, which will interfere the future calculation
                dq[i] = count[a] + 1  # 1 for self, count[a] for number of a
            elif (i >= a and dq[i-a]>1):
                dq[i] = dq[i -a ] - 1

    print(dq)
    for i in range(len(dq) // 2, -1 ,-1):
        if dq[i] > 0:
            return abs(S - 2 * i)
    return -1


# 63%
def solution_TE(A):
    # Implement your solution here
    S = 0 # Sum of the abs version of A 
    M = 0 # Max of the abs version of A 
    for i in range(len(A)):
        A[i] = abs(A[i])
        S += A[i]
        M = max(M, A[i])
    # print(S, M)
    # The goal is to find possible sum of subarray which is closetest to S / 2 
    # dq[i] = 1 mean it's possilbe to reach i, dq[i] = 0 mean it's not possible
    dq = [0] * (S + 1 )
    dq[0] = 1 # count the first one
    for a in A:
        i = S
        while (i >= 0):
            if dq[i] == 1 and i + a < len(dq):
                dq[i + a] = 1
            i -= 1
    # print(dq)
    for i in range(len(dq) // 2, -1 ,-1):
        if dq[i] == 1:
            return abs(S - 2 * i)
    return -1