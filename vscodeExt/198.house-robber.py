#
# @lc app=leetcode id=198 lang=python3
#
# [198] House Robber
#

# @lc code=start
class Solution:
    def rob(self, nums: List[int]) -> int:
        l = len(nums)
        if l == 0:
            return 0
        if l ==1:
            return nums[0]

        # n对应 最大的收益 
        res = nums[:]
        res[1] = max(nums[0], nums[1])

        for i in range(2,l):
            res[i] = max(res[i-2]+nums[i] , res[i-1] )

        print(res)
        return res[l-1]    
        
        
# @lc code=end

