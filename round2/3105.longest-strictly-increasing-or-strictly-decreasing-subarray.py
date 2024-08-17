#
# @lc app=leetcode id=3105 lang=python
#
# [3105] Longest Strictly Increasing or Strictly Decreasing Subarray
#

# @lc code=start
class Solution(object):
    def longestMonotonicSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #Get the increasing length and decreasing length 
        decreasing = 1
        increasing = 1
        # Use two flag to record the maximum in history
        max_increasing = 1
        max_decreasing = 1
        for i in range(1, len(nums)):
            if nums[i] > nums[i-1]:
                increasing += 1
                decreasing = 1
                max_increasing = max(max_increasing, increasing)
            elif nums[i] < nums[i-1]:
                decreasing += 1
                increasing = 1
                max_decreasing = max(max_decreasing, decreasing)
            # If the numbers are equal. Flag reset to true 
            else:
                increasing = 1
                decreasing = 1
        return max(max_decreasing, max_increasing)
        
# @lc code=end

