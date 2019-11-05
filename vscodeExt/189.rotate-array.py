#
# @lc app=leetcode id=189 lang=python3
#
# [189] Rotate Array
#

# @lc code=start
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k % len(nums) 
        if k == 0:
            return
        nums[:0] = nums[-k:]
        del  nums[-k:]
        
# @lc code=end

