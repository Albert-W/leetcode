#
# @lc app=leetcode id=896 lang=python
#
# [896] Monotonic Array
#

# @lc code=start
class Solution(object):
    def isMonotonic(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums) < 2:
            return True
        if nums[0] <= nums[-1]: # increasing # Can't compare with nums[1], because it may be equal 
            for i in range(0, len(nums) - 1):
                # print(nums[i], nums[i+1])
                if nums[i] > nums[i+1]:
                    return False
            return True
        else: # decreasing
            for i in range(0, len(nums) - 1):
                if nums[i] < nums[i+1]:
                    return False
            return True
            
        
# @lc code=end

