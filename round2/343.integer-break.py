#
# @lc app=leetcode id=343 lang=python
#
# [343] Integer Break
#

# @lc code=start
class Solution(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        # dq[n] is the maximum product of breaking n
        dq = [0] * (n+1)
        dq[1] = 1
        dq[2] = 1
        for i in range(3, n+1):
            # f(i) = max(f(i-j)* j, (i-j)*j)
            for j in range(1, i):
                dq[i] = max(dq[i], max(dq[i-j]*j, (i-j)*j ))
            # print(dq)
        return dq[n]
        
        
# @lc code=end

