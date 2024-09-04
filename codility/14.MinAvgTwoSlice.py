# A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

# For example, array A such that:

#     A[0] = 4
#     A[1] = 2
#     A[2] = 2
#     A[3] = 5
#     A[4] = 1
#     A[5] = 5
#     A[6] = 8
# contains the following example slices:

# slice (1, 2), whose average is (2 + 2) / 2 = 2;
# slice (3, 4), whose average is (5 + 1) / 2 = 3;
# slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
# The goal is to find the starting position of a slice whose average is minimal.

# Write a function:

# class Solution { public int solution(int[] A); }

# that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

# For example, given array A such that:

#     A[0] = 4
#     A[1] = 2
#     A[2] = 2
#     A[3] = 5
#     A[4] = 1
#     A[5] = 5
#     A[6] = 8
# the function should return 1, as explained above.

# Write an efficient algorithm for the following assumptions:

# N is an integer within the range [2..100,000];
# each element of array A is an integer within the range [−10,000..10,000].
# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # Implement your solution here
    # Get the sum of [0, i]
    # 最小平均值只能发生了2元组，三元组之中。
    # 证明：取四元组 【a,b,c,d】， 
    # if a + b < c + d, then avg(a, b) < avg(a, b, c, d)
    # if a + b > c + d, then avg(c, d) < avg(a, b, c, d)
    # so min avg slice will always be slice of 2 or 3 elements.
    sum_i = [A[0]]
    for i in range(1, len(A)):
        sum_i.append(sum_i[i-1] + A[i])
    
    min_avg = (A[0] + A[1]) / 2
    res = 0
    for i in range(len(A) - 1):
        for j in range(i+1, i + 3):
            if j < len(A):
                if (sum_i[j] - sum_i[i] + A[i]) / (j - i + 1) < min_avg:
                    min_avg = (sum_i[j] - sum_i[i] + A[i]) / (j - i + 1)
                    res = i
    return res 