#
# @lc app=leetcode id=416 lang=python3
#
# [416] Partition Equal Subset Sum
#

# @lc code=start
class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        mSum = sum(nums)
        if mSum % 2 == 1:
            return False

        # 辅助空间，判断package函数的返回值。
        memo = [False]* (mSum //2 + 1)
        C = mSum//2
        # 是否可以装满容量为C的背包
        return self.package( nums, memo, C)
    # dp Formula: 
    # F(i,c) = F(i-1, c) or F(i-1, c-w(i))
    def package(self, nums, memo, C):
        # 第一件物品可以填充的容量
        # [0,1,0,0,0,...0]
        for i in range(C+1):
            memo[i] = (nums[0] == i)
        # 第[0,i] 物品可以填充的。
        for i in range(1, len(nums)):
            # 反向考察
            # j 容量 在[C, nums[i]]中， 可以被两种方式填充。# 无素只能使用一次，只能用反向循环。  
            for j in range( C , nums[i]-1 , -1):
            # for j in range(  nums[i] , C + 1):
                memo[j] = memo[j] or memo[j - nums[i]]
 
        return memo[C] 
        



        
# @lc code=end

