#
# @lc app=leetcode id=3142 lang=python
#
# [3142] Check if Grid Satisfies Conditions
#

# @lc code=start
class Solution(object):
    def satisfiesConditions(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: bool
        """
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if i + 1 < len(grid) and grid[i][j] != grid[i + 1][j]:
                    return False
                if j + 1 < len(grid[0]) and grid[i][j] == grid[i][j + 1]:
                    return False
        return True
        
# @lc code=end

