#
# @lc app=leetcode id=3146 lang=python
#
# [3146] Permutation Difference between Two Strings
#

# @lc code=start
class Solution(object):
    def findPermutationDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        res = 0
        for i in range(len(s)):
            diff = abs(i - t.index(s[i]))
            res += diff
        return res
        
# @lc code=end

