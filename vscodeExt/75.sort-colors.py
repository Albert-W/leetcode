#
# @lc app=leetcode id=75 lang=python3
#
# [75] Sort Colors
#

# @lc code=start
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        zero = -1 #[0,zero] are zeroes
        two = len(nums) # [two, len(nums)-1] are twos 
        i = 0 
        while i < two:
            if nums[i] == 0:
                zero += 1
                nums[zero], nums[i] = nums[i], nums[zero]
                i += 1
            elif nums[i] == 1:
                i += 1
            else: # num[i] == 2
                two -= 1
                nums[i], nums[two] = nums[two], nums[i]
                         

        
# @lc code=end

