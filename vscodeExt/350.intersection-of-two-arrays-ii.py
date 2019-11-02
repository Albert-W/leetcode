#
# @lc app=leetcode id=350 lang=python3
#
# [350] Intersection of Two Arrays II
#

# @lc code=start
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        d = {}
        res = []
        for i in nums1:
            if i in d:
                d[i] += 1
            else:
                d[i] = 1    
        for i in nums2:
            if i in d and d[i] != 0: 
                res.append(i)
                d[i] -= 1
        return res        

# @lc code=end

