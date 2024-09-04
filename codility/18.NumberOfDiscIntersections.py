# We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

# We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

# The figure below shows discs drawn for N = 6 and A as follows:

#   A[0] = 1
#   A[1] = 5
#   A[2] = 2
#   A[3] = 1
#   A[4] = 4
#   A[5] = 0


# There are eleven (unordered) pairs of discs that intersect, namely:

# discs 1 and 4 intersect, and both intersect with all the other discs;
# disc 2 also intersects with discs 0 and 3.
# Write a function:

# class Solution { public int solution(int[] A); }

# that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

# Given array A shown above, the function should return 11, as explained above.

# Write an efficient algorithm for the following assumptions:

# N is an integer within the range [0..100,000];
# each element of array A is an integer within the range [0..2,147,483,647].
# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    
    # left and right boundary of each disk
    # any part out of the [0, len(A)-1] is meaningless, disc will have intersection within the [0, len(A)-1] range. 
    start = [0] * len(A) # how many disks start at i 
    end = [0] * len(A) # how many disks end at i
    
    for i in range(len(A)):
        left = max(0, i - A[i])
        right = min(len(A)-1, i + A[i])
        start[left] += 1
        end[right] += 1
    sum = 0
    in_middle = 0 # how many disks is already started but not ended at i. 
    for i in range(len(A)):
        # for all discs start at i, the intersection should be start[i] * (start[i] - 1) / 2
        sum += start[i] * (start[i] - 1) / 2
        # for part of the disc start at i, and the other part is not 
        sum += in_middle * start[i]
        in_middle += start[i] - end[i]
        if sum > 10000000:
            return -1
    return sum
        
    
    
    

    
    

def solution_E(A):
    disc = []
    for i in range(len(A)):
        disc.append([i - A[i], i + A[i]])
    _disc = sorted(disc) 
    # Set A is the bottom disc, B is the top disc
    bottom = 0
    top = len(A) - 1
    res = 0
    while bottom < top:
        if _disc[bottom][1] >= _disc[top][0]:
            res += top - bottom 
            if res > 10000000:
                return -1
            bottom += 1
            top = len(A) - 1
        else:
            top -= 1
    return res 
        
        

def solution_T(A):
    # Implement your solution here
    # each disk can be represent as [left, right]
    disc = []
    for i in range(len(A)):
        disc.append([i - A[i], i + A[i]])
    _disc = sorted(disc) 
    # print(_disc)
    res = 0
    for i in range(len(A)): 
        for j in range(i+1, len(A)): 
            # = means one point in common
            if _disc[j][0] <= _disc[i][1]:
                res += 1
                if res > 10000000:
                    return -1
    return res