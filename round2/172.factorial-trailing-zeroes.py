#
# @lc app=leetcode id=172 lang=python
#
# [172] Factorial Trailing Zeroes
#

# @lc code=start
class Solution(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        # Count 5s in n! 
        # if 25, 5*5, count 2 5s
        res = 0
        while n > 0:
            n /= 5
            res += n
        return res 
    
    def trailingZeroes_TLE(self, n):
        """
        :type n: int
        :rtype: int
        """
        factorial =[1]
        for i in range(1, n+1):
            factorial.append(factorial[-1] * i)
        res = 0
        n = factorial[-1]
        while n % 10 == 0:
            res += 1
            n /= 10
        return res
        
# @lc code=end

