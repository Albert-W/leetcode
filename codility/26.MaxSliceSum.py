# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # Implement your solution here
    # Same as Leetcode 53. Maximum Subarray
    dq = [0] * len(A)
    dq[0] = A[0]
    # max = A[0]
    for i in range(1, len(A)):
        if dq[i -1] <= 0:
            dq[i] = A[i]
        else:
            dq[i] = dq[i-1] + A[i]
    return max(dq)