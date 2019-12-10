#
# @lc app=leetcode id=343 lang=python3
#
# [343] Integer Break
#

# @lc code=start
class Solution:
    # 函数入口
    # 动态规划，需要两部分。
    def integerBreak(self, n: int) -> int:
        if n < 2:
            return -1  
        # list[n] 就是 n可以得到的最大值,方便下标使用
        list = [0] * (n+1)
        list[1] = 1
        list[2] = 1
        # max = 0
        # 从3算到n, 规模从小到大。
        for i in range(3, n+1):
            # 把i 分为两部分 j, i-j
            for j in range(1,i):
                # 存在i-j < list[i-j]的情况。
                list[i] = max( j* max(i-j,list[i-j]) , list[i] )
        return list[n]
        
# @lc code=end

