#
# @lc app=leetcode id=13 lang=python
#
# [13] Roman to Integer
#

# @lc code=start
class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        # Use two pointers to compare the current and previous values
        # Do not forget what you just go through.
        d = {
            'I':1,
            'V':5,
            'X':10,
            'L':50,
            'C':100,
            'D':500,
            'M':1000
        }
        res = 0
        previous = 0 
        for i in s:
            current = d[i]
            res += current 
            if current > previous:
                res -= 2 * previous
            previous = current
        return res
        
# @lc code=end

