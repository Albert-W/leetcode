# An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

# For example, consider array A such that

#  A[0] = 3    A[1] = 4    A[2] =  3
#  A[3] = 2    A[4] = 3    A[5] = -1
#  A[6] = 3    A[7] = 3
# The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

# Write a function

# class Solution { public int solution(int[] A); }

# that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

# For example, given array A such that

#  A[0] = 3    A[1] = 4    A[2] =  3
#  A[3] = 2    A[4] = 3    A[5] = -1
#  A[6] = 3    A[7] = 3
# the function may return 0, 2, 4, 6 or 7, as explained above.

# Write an efficient algorithm for the following assumptions:

# N is an integer within the range [0..100,000];
# each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

# Leetcode 169. Majority Element
def solution(A):
    # Implement your solution here
    if len(A) == 0: # Edge case - empty list
        return -1
    res = 0 # The index of the result
    count = 0 # The count of the dominator
    for i in range(len(A)):
        if A[i] == A[res]:
            count += 1
        else: 
            count -= 1
            if count == 0:
                res = i
                count = 1
    if A.count(A[res]) > len(A) / 2:
        return res  
    else: 
        return -1