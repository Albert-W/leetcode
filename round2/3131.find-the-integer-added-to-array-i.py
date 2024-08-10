#
# @lc app=leetcode id=3131 lang=python
#
# [3131] Find the Integer Added to Array I
#

# @lc code=start
class Solution(object):
    def addedInteger(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: int
        """
        return min(nums2) - min(nums1)
        
# @lc code=end

