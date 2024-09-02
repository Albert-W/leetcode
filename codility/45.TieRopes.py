# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(K, A):
    # Implement your solution here
    res = 0
    sum = 0
    for a in A:
        # Only adjacent ropes can be tied together
        sum += a  
        if sum >=K:
            sum = 0
            res += 1
    return res
    