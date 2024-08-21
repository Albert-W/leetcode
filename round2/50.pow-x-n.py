#
# @lc app=leetcode id=50 lang=python
#
# [50] Pow(x, n)
#

# @lc code=start
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n < 0:
            return 1.0 / self.myPow(x, -n)
        if n == 0:
            return 1
        if n == 1:
            return x
        if n % 2 == 0: 
            return self.myPow(x*x, n/2)
        else:
            return x * self.myPow(x*x, n/2)
# @lc code=end

