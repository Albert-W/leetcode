# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

# Check whether array A is a permutation.
def solution(A):
    # Implement your solution here
    l = [0] * len(A)
    for i in A:
        if i > len(A):
            return 0 
        if l[i - 1] == 1:
            return 0
        l[i - 1] = 1
    return 1 