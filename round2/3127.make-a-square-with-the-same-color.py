#
# @lc app=leetcode id=3127 lang=python
#
# [3127] Make a Square with the Same Color
#

# @lc code=start
class Solution(object):
    def canMakeSquare(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: bool
        """
        # If 3 in 2x2 grid are the same, return true. otherwise return false
        # count 2 * 2 grid, if w == 0, true, if w == 1, true; if w == 2 false, if w == 3 true
        
        
        
        for i in range(len(grid) - 1):
            for j in range(len(grid[0]) - 1):
                if self.count2x2(grid, i, j) != 2:
                    return True
        return False
    
    def count2x2(self, grid, i, j):
        w = 0
        if grid[i][j] == "W":
            w += 1
        if grid[i + 1][j] == "W":
            w += 1
        if grid[i][j + 1] == "W":
            w += 1
        if grid[i + 1][j + 1] == "W":
            w += 1
        return w
# @lc code=end

