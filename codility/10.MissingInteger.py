# This is a demo task.

# Write a function:

# class Solution { public int solution(int[] A); }

# that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

# For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

# Given A = [1, 2, 3], the function should return 4.

# Given A = [−1, −3], the function should return 1.

# Write an efficient algorithm for the following assumptions:

# N is an integer within the range [1..100,000];
# each element of array A is an integer within the range [−1,000,000..1,000,000].
# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

# Think about the edge cases, once submitted, I can't change it. 
def solution(A):
    # Implement your solution here
    path = [0] * len(A)
    for i in A:
        if i >= 1 and i <= len(A):
            path[i - 1] = 1 

    for i in range(len(A)):
        if path[i] == 0:
            return i + 1
    return len(A) + 1