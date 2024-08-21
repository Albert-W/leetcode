# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # Implement your solution here
    # Max profit from 1 tx 
    # similar to Leetcode 121. Best Time to Buy and Sell Stock
    if len(A) == 0:
        return 0
    # Keep track of the min price so far
    # If today's profit exceeds the max, update max
    _min = A[0]
    res = 0
    for a in A:
        if a < _min:
            _min = a   

        res = max(res, a - _min)
    return res 