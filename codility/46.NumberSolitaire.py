# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # Implement your solution here
    # The goal is to pick the max number in the adajacent 6 squares 

    res = 0
    _max = 0
    if len(A) <= 7:
        for i in range(1, len(A) - 1):
            res += max(_max, A[i])
        return A[0] + A[-1] + res
    
    # If the lengh is greater than 6, we need to record the possilbe results. 
    record = [0] * len(A)
    record[0] = A[0]
    # record[1] = A[1] + max(0, A[0])
    for i in range(1, 7):
        # print(A[i], max(record[0:i]))
        record[i] = A[i] + max(record[0:i])
    for i in range(7, len(A)):
        record[i] = A[i] + max(record[i-6:i])
    # print(record)
    return record[len(A) - 1]