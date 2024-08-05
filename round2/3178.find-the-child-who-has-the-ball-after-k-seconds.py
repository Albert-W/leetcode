#
# @lc app=leetcode id=3178 lang=python
#
# [3178] Find the Child Who Has the Ball After K Seconds
#

# @lc code=start
class Solution(object):
    def numberOfChild(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        new_k = k % (2 * n - 2)
        if new_k < n - 1:
            return new_k 
        else:
            return 2 * n - new_k - 2
        
# @lc code=end

