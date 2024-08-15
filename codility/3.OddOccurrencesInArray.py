# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # Implement your solution here
    res = 0
    for i in A:
        res ^= i
    return res