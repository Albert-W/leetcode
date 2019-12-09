#
# @lc app=leetcode id=343 lang=python3
#
# [343] Integer Break
#

# @lc code=start
class Solution:
    def integerBreak(self, n: int) -> int:
        if n < 2:
            return -1  
        # list[n-1] 就是 n可以得到的最大值
        list = [-1] * n
        # print(list)
        list[0] = 1
        list[1] = 1
        # list[2] = 2
        max = 0
        for i in range( (n-1)//2):
            if list[i] * list[n-1-i] > max:
                max = list[i] * list[n-1-i]
        return max 
        
# @lc code=end

