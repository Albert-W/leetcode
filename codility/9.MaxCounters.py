# You are given N counters, initially set to 0, and you have two possible operations on them:

# increase(X) − counter X is increased by 1,
# max counter − all counters are set to the maximum value of any counter.
# A non-empty array A of M integers is given. This array represents consecutive operations:

# if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
# if A[K] = N + 1 then operation K is max counter.
# For example, given integer N = 5 and array A such that:

#     A[0] = 3
#     A[1] = 4
#     A[2] = 4
#     A[3] = 6
#     A[4] = 1
#     A[5] = 4
#     A[6] = 4
# the values of the counters after each consecutive operation will be:

#     (0, 0, 1, 0, 0)
#     (0, 0, 1, 1, 0)
#     (0, 0, 1, 2, 0)
#     (2, 2, 2, 2, 2)
#     (3, 2, 2, 2, 2)
#     (3, 2, 2, 3, 2)
#     (3, 2, 2, 4, 2)
# The goal is to calculate the value of every counter after all operations.

# Write a function:

# class Solution { public int[] solution(int N, int[] A); }

# that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

# Result array should be returned as an array of integers.

# For example, given:

#     A[0] = 3
#     A[1] = 4
#     A[2] = 4
#     A[3] = 6
#     A[4] = 1
#     A[5] = 4
#     A[6] = 4
# the function should return [3, 2, 2, 4, 2], as explained above.

# Write an efficient algorithm for the following assumptions:

# N and M are integers within the range [1..100,000];
# each element of array A is an integer within the range [1..N + 1].
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