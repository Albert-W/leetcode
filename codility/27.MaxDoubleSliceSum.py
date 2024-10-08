# A non-empty array A consisting of N integers is given.

# A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.

# The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

# For example, array A such that:

#     A[0] = 3
#     A[1] = 2
#     A[2] = 6
#     A[3] = -1
#     A[4] = 4
#     A[5] = 5
#     A[6] = -1
#     A[7] = 2
# contains the following example double slices:

# double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
# double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
# double slice (3, 4, 5), sum is 0.
# The goal is to find the maximal sum of any double slice.

# Write a function:

# class Solution { public int solution(int[] A); }

# that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.

# For example, given:

#     A[0] = 3
#     A[1] = 2
#     A[2] = 6
#     A[3] = -1
#     A[4] = 4
#     A[5] = 5
#     A[6] = -1
#     A[7] = 2
# the function should return 17, because no double slice of array A has a sum of greater than 17.

# Write an efficient algorithm for the following assumptions:

# N is an integer within the range [3..100,000];
# each element of array A is an integer within the range [−10,000..10,000].
# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message"

def solution(A):
    # Implement your solution here
    # get the max sum from 1 to len(A) - 2 as left_sum
    # get the max sum from len(A) - 2 to 1 as right_sum
    # return the max sum from left_sum[i] + right_sum[i]

    left_sum = [0] * len(A) # [0, i)
    # start from A[1] to A[-2]
    for i in range(2, len(A) -1 ):
        left_sum[i] = max(0, left_sum[i-1] + A[i - 1])
    print(left_sum)
    right_sum = [0] * len(A) # [i + 1, -1]
    # start from A[len(A) - 2] to A[1]
    for i in range(len(A)-3, 0, -1):
        right_sum[i] = max(0, right_sum[i + 1] + A[i + 1]) 
    print(right_sum)#
    res = 0
    for i in range(1, len(A)-1):
        res = max(res, left_sum[i] + right_sum[i])
    return res