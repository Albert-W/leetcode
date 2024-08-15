#
# @lc app=leetcode id=3120 lang=python
#
# [3120] Count the Number of Special Characters I
#

# @lc code=start
class Solution(object):
    def numberOfSpecialChars(self, word):
        """
        :type word: str
        :rtype: int
        """
        
        # ord('a') = 97, ord('A') = 65
        s = set()
        for i in word:
            if ord(i) > 96 and i.upper() in word:
                s.add(i)
        return len(s)
        
# @lc code=end

