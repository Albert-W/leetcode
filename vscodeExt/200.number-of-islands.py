#
# @lc app=leetcode id=200 lang=python3
#
# [200] Number of Islands
#

# @lc code=start
class Solution:
    d = [(-1,0),(0,1),(1,0),(0,-1)]
    isVisited = []
    m = 0
    n = 0 
    #  函数入口
    def numIslands(self, grid: List[List[str]]) -> int:
        self.m = len(grid)
        if self.m == 0:
            return 0 
        self.n = len(grid[0])    

        self.isVisited = [ [False for i in range(self.n)] for j in range(self.m)  ]
        # print(isVisited)
        count = 0
        for i in range(self.m):
            for j in range(self.n):
                # print(i,j,self.isVisited)
                if grid[i][j]=='1' and self.isVisited[i][j] == False:
                    count += 1
                    #每次进入foodfill中查找
                    self.floodfill(grid, i, j )
        return count

    def isValid(self, i,j):
        return i>=0 and i<self.m and j>=0 and j<self.n

    # floodfill 重点在于标记。
    # 不需要回溯，也就不需要重新标记为False
    def floodfill(self, grid, x, y):

        self.isVisited[x][y] = True
        for k in range(4):
            newX = x + self.d[k][0]
            newY = y + self.d[k][1]
            if self.isValid(newX, newY) and self.isVisited[newX][newY] == False and grid[newX][newY] == '1':
                self.floodfill(grid, newX, newY)
        return



# @lc code=end

