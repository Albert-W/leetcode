#
# @lc app=leetcode id=322 lang=python3
#
# [322] Coin Change
#

# @lc code=start
class Solution:
    # 01 背包问题，函数入口
    # memo[j] = min(memo[j], memo[ j%coins[i] ] + j //coins[i] )  不行，需要循环。
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount <= 0 :
            return 0
        # 使用最小化时不应用 -1来标记
        memo = [amount+2] * (amount+1)

        coins.sort()
        print(coins)
        return self.package(coins, memo, amount)

    # Time Limit Exceeded 37/182 
    def package(self, coins, memo, C):
        for i in range(C+1):
            if i % coins[0] == 0:
                memo[i] = i//coins[0]
            
        for i in range(1, len(coins)):
            for j in range(C, coins[i]-1, -1):
                k = j - coins[i]
                while k >= 0 and memo[k] <= C :
                    memo[j] = min(memo[j], memo[ k ] + (j-k) //coins[i] )    
                    k = k - coins[i]


            print(memo)
        if memo[C] > C:
            return -1
        else:

            return memo[C]    

         
        

# @lc code=end

