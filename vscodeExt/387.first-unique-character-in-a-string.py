#
# @lc app=leetcode id=387 lang=python3
#
# [387] First Unique Character in a String
#

# @lc code=start
class Solution:
    def firstUniqChar(self, s: str) -> int:
        charL = [0]*26
        for i in s:
            charL[ ord(i) - ord('a') ] += 1

        for i in range(len(s)):
            if charL[ord(s[i]) - ord('a')] == 1:
                return i
        return -1        
        
# @lc code=end

