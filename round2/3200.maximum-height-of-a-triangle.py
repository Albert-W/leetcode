#
# @lc app=leetcode id=3200 lang=python
#
# [3200] Maximum Height of a Triangle
#

# @lc code=start


import math


class Solution(object):
    def maxHeightOfTriangle(self, red, blue):
        """
        :type red: int
        :type blue: int
        :rtype: int
        """
        min_ball = min(red, blue)
        diff_ball = abs(red - blue)
        height_1 = int(math.ceil(math.sqrt(min_ball))) * 2 - 1
        if diff_ball >= height_1:
            height_1 += 1
            
        height_2 =  (int(math.sqrt(1 + 4 * min_ball)) - 1) // 2 + 1
        return max(height_1, height_2)
        
# @lc code=end

