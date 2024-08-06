#
# @lc app=leetcode id=3174 lang=python
#
# [3174] Clear Digits
#

# @lc code=start
class Solution(object):
    def clearDigits(self, s):
        """
        :type s: str
        :rtype: str
        """
        # Index is changing,  
        list_s = list(s)
        k = 0
        for i in range(len(s)):
            if s[i].isdigit():
                if i > 0:
                    list_s.pop(i - 1)
                    list_s.insert(0, "")
                list_s.pop(i)
                list_s.insert(0, "")
        return "".join(list_s)

        
# @lc code=end

