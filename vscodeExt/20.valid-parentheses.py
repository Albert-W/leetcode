#
# @lc app=leetcode id=20 lang=python3
#
# [20] Valid Parentheses
#

# @lc code=start
class Solution:
    def isValid(self, s: str) -> bool:
        d = {
            '(': ')',
            '{': '}',
            '[': ']' 
        }
        stack = []
        for i in s:
            # 如果找到匹配项
            if len(stack) > 0 and stack[-1] in d and i == d[stack[-1]]:
                
                stack.pop() 
            # 如果没到找匹配项
            else:
                stack.append(i)
        if len(stack)==0:
            return True
        else:
            return False                 
# @lc code=end

