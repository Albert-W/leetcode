#
# @lc app=leetcode id=20 lang=python
#
# [20] Valid Parentheses
#

# @lc code=start
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # Use a stack to store the left parentheses
        stack = []
        d = {
            ')':'(',
            '}':'{',
            ']':'['
        }
        for i in s:
            if i in d:
                if len(stack) == 0:
                    return False
                symbol = stack.pop()
                if d[i] != symbol:
                    return False
            else:
                stack.append(i)
        return len(stack) == 0
        
# @lc code=end

