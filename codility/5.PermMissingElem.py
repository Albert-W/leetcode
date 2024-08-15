# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

# Find the missing element in a given permutation.
def solution(A):
    # Implement your solution here
    if len(A) == 0:
        return 1
    new = sorted(A) 
    for i in range(len(A)):
        if new[i] != i + 1:
            return i + 1
    return len(A) + 1