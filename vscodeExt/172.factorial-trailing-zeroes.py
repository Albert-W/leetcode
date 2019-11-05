#
# @lc app=leetcode id=172 lang=python3
#
# [172] Factorial Trailing Zeroes
#

# @lc code=start
class Solution:
    def trailingZeroes(self, n: int) -> int:
        res = 0
        while n != 0 :
            n = n//5
            res += n
        return res
        
# @lc code=end

