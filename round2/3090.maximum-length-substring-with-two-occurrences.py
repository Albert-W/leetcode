#
# @lc app=leetcode id=3090 lang=python
#
# [3090] Maximum Length Substring With Two Occurrences
#

# @lc code=start
class Solution(object):
    def maximumLengthSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        left = 0 
        right = 1
        res = 2
        while right < len(s):
            # If right reaches the end, we need update the res 
            if s[left: right+1].count(s[right]) <= 2:
                res = max(res, right - left + 1)
                right += 1
            else:
                res = max(res, right - left)
                left += 1
        return res
        
        # def isValid(s):
        #     m = {}
        #     for c in s:
        #         if c in m:
        #             m[c] += 1
        #             if m[c] > 2:
        #                 return False
        #         else:
        #             m[c] = 1
        #     return True
        # res = 2
        # for i in range(len(s)):
        #     for j in range(i+1, len(s)):
        #         if isValid(s[i:j+1]):
        #             res = max(res, j - i + 1)
        # return res

        
        
# @lc code=end

