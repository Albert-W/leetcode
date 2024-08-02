#
# @lc app=leetcode id=3232 lang=python
#
# [3232] Find if Digit Game Can Be Won
#

# @lc code=start
class Solution(object):
    def canAliceWin(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        # If the sum of 1 digits are equal to sum of 2 digits, return false, otherwise return true. 
        sum1 = sum2 = 0
        for i in nums:
            if i // 10 > 0:
                sum2 += i
            else:
                sum1 += i
        return sum1 != sum2
        
# @lc code=end

