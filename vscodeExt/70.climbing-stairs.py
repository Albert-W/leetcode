#
# @lc app=leetcode id=70 lang=python3
#
# [70] Climbing Stairs
#

# @lc code=start
class Solution:
    def climbStairs_E1(self, n: int) -> int:
        # dynamic programming 
        # Time Limit Exceeded
        if n == 1:
            return 1
        if n == 2:
            return 2
        return self.climbStairs(n-2) + self.climbStairs(n-1)   
        
    def climbStairs(self, n: int) -> int:
    # iteration

        if n == 1:
            return 1
        if n == 2:
            return 2
        a = 1
        b = 2
        c = 0 
        i = 3
        while i<=n:
            c = a+b
            a = b
            b = c

            i+=1          
        return c 


        
# @lc code=end

