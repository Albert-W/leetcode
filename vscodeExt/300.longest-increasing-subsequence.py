#
# @lc app=leetcode id=300 lang=python3
#
# [300] Longest Increasing Subsequence
#

# @lc code=start
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # max() 不能为空
        if len(nums) == 0:
            return 0
        # 起步长度为1,记录包含本元素的最大子长度。     
        memo = [1]*len(nums)
        
        for i in range(1, len(nums)):
            j = i -1 
            while j >= 0 :
                if nums[j]< nums[i]:
                    memo[i] =max(memo[i], memo[j] + 1)
                    # break
                j = j -1     
        print(memo)
        # 返回最大值。 
        return max(memo)
        
# @lc code=end

