# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")
import math
def solution(N):
    res = 0
    s = int(math.sqrt(N))
    for i in range(1, s+1):
        if N % i == 0:
            res += 1
    if s * s == N:
        return 2 * res - 1
    else:
        return 2 * res


def solution_E(N):
    # Implement your solution here
    res = 1
    i = 1
    factors = set()
    while i <= N:
        if N % i == 0:
            set.add(1)
            N = N // i
        i += 1
        
    return pow(2, len(factors))


def solution_TE(N):
    # Implement your solution here
    res = 1
    for i in range(1, N//2 + 1):
        if N % i == 0:
            res += 1
            # print(i)
    return res