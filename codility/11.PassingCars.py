# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # Implement your solution here
    # The first loop calculate how many 1's ahead. 
    # The second loop calculate the result 
    # !!! Pay attention to the requirement of the problem.
    l = len(A)
    sum = 0
    res = 0
    for i in range(l-1 , -1, -1):
        if A[i] == 1:
            sum += 1

        else:
            res += sum 
            if res > 1000000000:
                return -1 
    return res