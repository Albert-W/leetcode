#
# @lc app=leetcode id=29 lang=python3
#
# [29] Divide Two Integers
#

# @lc code=start
class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        if dividend == - 2 ** 31 and divisor == -1:
            return 2 ** 31 -1
        res = dividend / divisor
        if res >= 0:
            return int(res)
        else: 
            return -int(abs(res))
        
# @lc code=end

