# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

# Think about the edge cases, once submitted, I can't change it. 
def solution(A):
    # Implement your solution here
    path = [0] * len(A)
    for i in A:
        if i >= 1 and i <= len(A):
            path[i - 1] = 1 

    for i in range(len(A)):
        if path[i] == 0:
            return i + 1
    return len(A) + 1