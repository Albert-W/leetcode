#
# @lc app=leetcode id=3226 lang=python
#
# [3226] Number of Bit Changes to Make Two Integers Equal
#

# @lc code=start
class Solution(object):
    def minChanges(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        # Get the XOR result. all the 1s in the result means they are different.
        # if the 1s are from k, return -1. Otherwise, return the number of 1s.
        xor = n ^ k 
        if xor + k != n:
            return -1
        return bin(xor).count('1')
# @lc code=end

