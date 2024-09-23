#
# @lc app=leetcode id=241 lang=python3
#
# [241] Different Ways to Add Parentheses
#

# @lc code=start
class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        if len(expression) <= 2:
            return [int(expression)]
        
        res = []
        
        for i, v in enumerate(expression):
            if v in "-+*":
                left = self.diffWaysToCompute(expression[:i])
                right = self.diffWaysToCompute(expression[i+1:])
                for l in left:
                    for r in right:
                        if v == '-':
                            res.append(l - r)
                        elif v == '+':
                            res.append(l + r)
                        else:
                            res.append(l * r)
        return res

        
# @lc code=end

