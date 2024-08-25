#
# @lc app=leetcode id=905 lang=python
#
# [905] Sort Array By Parity
#

# @lc code=start
class Solution(object):
    def sortArrayByParity(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        return [i for i in nums if i % 2 == 0] + [i for i in nums if i % 2 == 1]
        
# @lc code=end

