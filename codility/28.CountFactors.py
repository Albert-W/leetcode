# A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

# For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

# Write a function:

# class Solution { public int solution(int N); }

# that, given a positive integer N, returns the number of its factors.

# For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

# Write an efficient algorithm for the following assumptions:

# N is an integer within the range [1..2,147,483,647].
# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")
import math
def solution(N):
    res = 0
    # s = int(math.sqrt(N))
    s = int(N ** 0.5)
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