#
# @lc app=leetcode id=1025 lang=python3
#
# [1025] Divisor Game
#

# @lc code=start
class Solution:
    # 动态规划版
    def divisorGame(self, N: int) -> bool:
        if N <= 1:
            return False
        res = [False]*(N+1)
        res[2] = True
        # 得到[3，N]的结果
        # flg = True
        for i in range(3,N+1):
            # 开始动态规划
            for j in range(1, i):
                if i % j == 0 and res[i-j] == False:
                    res[i] = True
                    break      


        return res[N]        


    def divisorGame_T1(self, N: int) -> bool:
        return N % 2 == 0
        
# @lc code=end

