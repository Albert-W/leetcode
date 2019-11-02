#
# @lc app=leetcode id=283 lang=python3
#
# [283] Move Zeroes
#

# @lc code=start
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = 0 #[0,k) are non-zeroes
        i = 0 
        while i < len(nums):
            if nums[i] :
                nums[k] = nums[i]
                k += 1
            
            i+=1    
        while k < len(nums):
            nums[k]  = 0 
            k+=1

# @lc code=end

