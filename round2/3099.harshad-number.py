#
# @lc app=leetcode id=3099 lang=python
#
# [3099] Harshad Number
#

# @lc code=start
class Solution(object):
    def sumOfTheDigitsOfHarshadNumber(self, x):
        """
        :type x: int
        :rtype: int
        """
        s = 0
        old = x # x is changed, save the original value
        while x: 
            x, r = divmod(x, 10)
            s += r
        if old % s == 0:
            return s 
        return -1
        
# @lc code=end

