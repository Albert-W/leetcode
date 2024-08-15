# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(N, A):
    # Get timeout error for large inputs 
    # Implement your solution here
    # Use two labels to remove the nested loop.
    # O(N + M)
    res = [0] *  N 
    max_for_all = 0 # in res[], Below this value will be set to it 
    max_for_current = 0 # Keep track of the maximum in res[], ready to be set to max_for_all
    for i in A: 
        if i <= N: 
            if res[i - 1] < max_for_all:
                res[i - 1] = max_for_all + 1
            else:
                res[i - 1] += 1
            max_for_current = max(max_for_current, res[i - 1])
        else: 
            max_for_all = max_for_current
        # print(m)
    for i in range(N):
        if res[i] < max_for_all:
            res[i] = max_for_all
    
    return res