#
# @lc app=leetcode id=892 lang=python
#
# [892] Surface Area of 3D Shapes
#

# @lc code=start
class Solution(object):
    def surfaceArea(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """

        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] != 0:
                    # Count all the surface of one stack. 
                    res += grid[i][j] * 6 - (grid[i][j] - 1) * 2 
                    # Subtract the area of adjacent blocks.
                    if i < len(grid) - 1:
                        res -= min(grid[i][j], grid[i + 1][j]) * 2
                    if j < len(grid[0]) - 1:
                        res -= min(grid[i][j], grid[i][j + 1]) * 2
        return res
    
                    

# @lc code=end

