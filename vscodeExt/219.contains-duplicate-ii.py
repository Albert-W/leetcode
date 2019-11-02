#
# @lc app=leetcode id=219 lang=python3
#
# [219] Contains Duplicate II
#

# @lc code=start
class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        s = set()
        # l = 0 
        # r = k  # 初始窗口为[0, k]
        i = 0 
        while i < len(nums):
            if nums[i] in s:
                return True
            else:
                s.add(nums[i])

            if len(s) == k+1:
                s.remove(nums[i-k])


            i+=1    
        return False
        
# @lc code=end

