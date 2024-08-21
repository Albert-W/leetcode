#
# @lc app=leetcode id=70 lang=python
#
# [70] Climbing Stairs
#

# @lc code=start
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        # 1. dp[i] = dp[i-1] + dp[i-2]
        # 2. dp[0] = 1, dp[1] = 1
        # Record what happened in the past. 
        # Dynamic programming 
        if n < 3:
            return n
        dp = [1, 1]
        for i in range(2, n+1):
            dp.append(dp[i-1] + dp[i-2])
        return dp[n]

    def climbStairs_TLE(self, n):
        """
        :type n: int
        :rtype: int
        """
        # Recursion 
        if n < 3:
            return n
        return self.climbStairs(n-1) + self.climbStairs(n-2)
        
# @lc code=end

