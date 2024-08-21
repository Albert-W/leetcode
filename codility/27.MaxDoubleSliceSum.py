# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message"

def solution(A):
    # Implement your solution here
    # get the max sum from 1 to len(A) - 2 as left_sum
    # get the max sum from len(A) - 2 to 1 as right_sum
    # return the max sum from left_sum[i] + right_sum[i]

    left_sum = [0] * len(A) # [0, i)
    # start from A[1] to A[-2]
    for i in range(2, len(A) -1 ):
        left_sum[i] = max(0, left_sum[i-1] + A[i - 1])
    print(left_sum)
    right_sum = [0] * len(A) # [i + 1, -1]
    # start from A[len(A) - 2] to A[1]
    for i in range(len(A)-3, 0, -1):
        right_sum[i] = max(0, right_sum[i + 1] + A[i + 1]) 
    print(right_sum)#
    res = 0
    for i in range(1, len(A)-1):
        res = max(res, left_sum[i] + right_sum[i])
    return res