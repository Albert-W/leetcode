#
# @lc app=leetcode id=2419 lang=python3
#
# [2419] Longest Subarray With Maximum Bitwise AND
#

# @lc code=start
class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        # The goal is to find the max length of consecutive maximum item in an array
        max_ = max(nums)
        res = 0
        count = 0
        for i in nums:
            if i == max_:
                count += 1
                res = max(res, count)
            else:
                count = 0
        return res
        
        
# @lc code=end

