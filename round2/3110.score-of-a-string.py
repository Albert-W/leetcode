#
# @lc app=leetcode id=3110 lang=python
#
# [3110] Score of a String
#

# @lc code=start
class Solution(object):
    def scoreOfString(self, s):
        """
        :type s: str
        :rtype: int
        """
        res = 0
        for i in range(len(s)-1):
            res += abs(ord(s[i]) - ord(s[i+1]))
        return res
        
# @lc code=end

