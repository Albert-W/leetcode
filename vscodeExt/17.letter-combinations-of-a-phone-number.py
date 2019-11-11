#
# @lc app=leetcode id=17 lang=python3
#
# [17] Letter Combinations of a Phone Number
#

# @lc code=start
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        # 不使用循环遍历，而使用递归。
        # 也可以用list 替代，下标可用。 
        d = {
            '1':"",
            '2':'abc',
            '3':'def',
            '4':'ghi',
            '5':'jkl',
            '6':'mno',
            '7':'pqrs',
            '8':'tuv',
            '9':'wxyz'
        }
        # 出口
        if len(digits) == 0:
            return []
        if len(digits) == 1:
            return d[digits[0]]    
        # 最终结果
        res = []
        # 问题规模为 n-1的情况
        tem = self.letterCombinations(digits[1:])
        for i in d[digits[0]]:
            for item in tem:
                res.append(i+item)
        return res         



# @lc code=end

