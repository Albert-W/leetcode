# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(N, A):
    # Get timeout error for large inputs 
    # Implement your solution here
    # Use two labels to remove the nested loop.
    # O(N + M)
    res = [0] *  N 
    min_ = 0 # in res[], Below this value will be set to it 
    max_ = 0 # Keep track of the maximum in res[], ready to be set to min_
    for i in A: 
        if i <= N: 
            if res[i - 1] < min_:
                res[i - 1] = min_ + 1
            else:
                res[i - 1] += 1
            max_ = max(max_, res[i - 1])
        else: 
            min_ = max_
        # print(m)
    for i in range(N):
        if res[i] < min_:
            res[i] = min_
    
    return res