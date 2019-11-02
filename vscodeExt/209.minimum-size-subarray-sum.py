#
# @lc app=leetcode id=209 lang=python3
#
# [209] Minimum Size Subarray Sum
#

# @lc code=start
class Solution:
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        minlen = len(nums) + 1 # 取正常不能获得的最大值
        # if minlen == 0:
        #     return 0
        # if sum(nums) < s:
        #     return 0
        l = 0 
        r = -1 #[l...r] 为滑动区间，不包括任何值
        mySum = 0 
        while r < len(nums):
            if mySum < s :
                r += 1
                if r < len(nums):
                    mySum += nums[r]
            if mySum >= s:
                # print(mySum)
                if r-l + 1 < minlen:
                    minlen = r -l + 1
                mySum -= nums[l]     
                l += 1
        if minlen == len(nums) + 1:
            return 0

        return minlen
# @lc code=end

