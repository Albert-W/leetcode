# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

# Leetcode 169. Majority Element
def solution(A):
    # Implement your solution here
    if len(A) == 0: # Edge case - empty list
        return -1
    res = 0 # The index of the result
    count = 0 # The count of the dominator
    for i in range(len(A)):
        if A[i] == A[res]:
            count += 1
        else: 
            count -= 1
            if count == 0:
                res = i
                count = 1
    if A.count(A[res]) > len(A) / 2:
        return res  
    else: 
        return -1