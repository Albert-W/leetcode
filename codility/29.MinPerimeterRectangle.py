import math
def solution(N):
    # Implement your solution here
    sq = math.sqrt(N)
    i = int(sq)
    while i >= 1:
        if N % i == 0:
            return 2 * (i + N // i) 
        else: 
            i -= 1
    return 0