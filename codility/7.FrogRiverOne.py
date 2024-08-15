# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

# Find the earliest time when a frog can jump to the other side of a river.
def solution(X, A):
    # Implement your solution here
    # Time out error for large inputs
    path = [0] * X 

    # for i in range(len(A)):
    #     if A[i] <= X:
    #         path[A[i] - 1] = 1 
    #         # print(path)
    #         if min(path) == 1:
    #             return i 
    # return -1
    cur = 0
    for i in range(len(A)): 
        if A[i] <= X: 
            path[A[i] - 1] = 1 
            while path[cur] == 1:
                cur += 1
                if cur == X:
                    return i
    return -1 