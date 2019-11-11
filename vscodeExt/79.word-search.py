#
# @lc app=leetcode id=79 lang=python3
#
# [79] Word Search
#

# @lc code=start
class Solution:
    d = [(-1,0),(0,1),(1,0),(0,-1)]
    isVisited = []
    m = 0
    n = 0


    def exist(self, board: List[List[str]], word: str) -> bool:
        if len(board) == 0 :
            return False
        self.m = len(board)
        self.n = len(board[0])
        self.isVisited = [[False]*self.n]*self.m 
        print(self.isVisited)
        for i in range(self.m):
            for j in range(self.n):
                # 如果找到了就返回True
                # 没找到就循环找
                if self.findWord(board, word, i,j):
                    return True
        return False


    def isValid(self, x, y):
        return x>= 0 and x<self.m and y >=0 and y< self.n

    def findWord(self, board, word, x, y):
        if board[x][y] != word[0]:
            return False
        # 定义递归出口
        if len(word)==1 and board[x][y] == word[0]:
            return True  
        self.isVisited[x][y] == True    
        for i in range(4):
            newX = x + self.d[i][0]
            newY = y + self.d[i][1]
            print(newX, newY)
            if self.isValid(newX, newY) and self.isVisited[newX][newY] == False:
                return self.findWord(board,word[1:], newX, newY)
        # 四周没找到，回滚
        self.isVisited[x][y] == False        


        

        
# @lc code=end

