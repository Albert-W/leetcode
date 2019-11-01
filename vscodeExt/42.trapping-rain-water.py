#
# @lc app=leetcode id=42 lang=python3
#
# [42] Trapping Rain Water
#

# @lc code=start
class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) < 3:
            return 0 
        i = 1 # for index, start from 1
        water = 0 
        highest = height[0]
        while i < len(height):
            if height[i]>highest:
                highest = height[i]
            else:
                water += highest-height[i] # 最多能载水量
            i += 1    
        # 减去可流失的水量
        # 倒序计算
        j = 0 
        rail = height[-1]
        while j < len(height) and height[-1-j]< highest:
            if height[-1-j] > rail:
                rail = height[-1-j]
            water -= highest - rail
            j += 1
        return water               

        
# @lc code=end

