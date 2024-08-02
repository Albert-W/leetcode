#
# @lc app=leetcode id=3216 lang=python
#
# [3216] Lexicographically Smallest String After a Swap
#

# @lc code=start
class Solution(object):
    def getSmallestString(self, s):
        """
        :type s: str
        :rtype: str
        """
        s_list = list(s)
        # The first swap will be the smallest number
        
        for i in range(1, len(s)):
            pre = int(s[i-1])
            cur = int(s[i])
            
            if pre > cur and (pre ^ cur) % 2 == 0:
                # print(pre, cur)
                s_list[i-1], s_list[i] = s_list[i], s_list[i-1]
                return "".join(s_list)
        return s
            
        
# @lc code=end

