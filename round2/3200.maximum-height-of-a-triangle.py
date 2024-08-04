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
        # min_ball = min(red, blue)
        # diff_ball = abs(red - blue)
        # height_1 = int(math.floor(math.sqrt(min_ball))) * 2 - 1
        # if diff_ball >= height_1:
        #     height_1 += 1
            
        # height_2 =  (int(math.sqrt(1 + 4 * min_ball)) - 1) // 2 

        # if diff_ball > height_2:
        #     height_2 = height_2 * 2 + 1
        # else:
        #     height_2 = height_2 * 2 
        # # print(height_1, height_2)
        # return max(height_1, height_2)
        
        # The above solution is using math, but it is not correct and difficult to understand.
        
        res_1 = 0
        blue_1 = blue
        red_1 = red
        # Red first and Blue second
        while red_1 >= res_1 + 1 and blue_1 >= res_1 + 2:
            red_1 -= res_1 + 1
            blue_1 -= res_1 + 2
            res_1 += 2
        if red_1 >= res_1 + 1:
            res_1 += 1
            
        # Blue first and Red second
        res_2 = 0
        blue_2 = blue
        red_2 = red
        while blue_2 >= res_2 + 1 and red_2 >= res_2 + 2:
            blue_2 -= res_2 + 1
            red_2 -= res_2 + 2
            res_2 += 2
        if blue_2 >= res_2 + 1:
            res_2 += 1
        return max(res_1, res_2)
        
# @lc code=end

