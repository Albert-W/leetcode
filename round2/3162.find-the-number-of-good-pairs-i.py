#
# @lc app=leetcode id=3162 lang=python
#
# [3162] Find the Number of Good Pairs I
#

# @lc code=start
class Solution(object):
    def numberOfPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: int
        """
        res = 0
        for i in nums1:
            for j in nums2:
                if i % (j * k) == 0:
                    res += 1
        return res

# @lc code=end

