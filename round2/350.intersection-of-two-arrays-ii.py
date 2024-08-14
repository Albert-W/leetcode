#
# @lc app=leetcode id=350 lang=python
#
# [350] Intersection of Two Arrays II
#

# @lc code=start
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        res = []
        
        for i in nums1:
            if i in nums2:
                res.append(i)
                nums2.remove(i)
        return res
        
# @lc code=end

