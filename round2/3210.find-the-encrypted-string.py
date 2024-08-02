#
# @lc app=leetcode id=3210 lang=python
#
# [3210] Find the Encrypted String
#

# @lc code=start
class Solution(object):
    def getEncryptedString(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        s_list = list(s)
        for i in range(len(s)):
            s_list[i] = s[((i + k) % len(s))]
        return "".join(s_list)

# @lc code=end

