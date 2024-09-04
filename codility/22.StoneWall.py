# You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

# The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

# Write a function:

# class Solution { public int solution(int[] H); }

# that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

# For example, given array H containing N = 9 integers:

#   H[0] = 8    H[1] = 8    H[2] = 5
#   H[3] = 7    H[4] = 9    H[5] = 8
#   H[6] = 7    H[7] = 4    H[8] = 8
# the function should return 7. The figure shows one possible arrangement of seven blocks.



# Write an efficient algorithm for the following assumptions:

# N is an integer within the range [1..100,000];
# each element of array H is an integer within the range [1..1,000,000,000].
def solution(H):
    # 
    s = [] # a stack of the heights, no block is lower then them. 
    res = 0
    for b in H:

        # if the current block is lower the the stop of the stack. 
        while len(s) > 0 and b < s[-1]:
            s.pop()
            res += 1
        if len(s) == 0 or b > s[-1]:
            s.append(b)
            
    return res + len(s)


def solution_E(H):
    # Implement your solution here
    _min = 0
    res = 1
    for i in range(1,len(H)): 
        # print(H[_min:i])
        if H[i] in H[_min:i]:
            continue
        else: 
            res += 1
            if H[i] < H[_min]:
                _min = i
        
    return res