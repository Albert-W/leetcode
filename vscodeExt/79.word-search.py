#
# @lc app=leetcode id=79 lang=python3
#
# [79] Word Search
#

# @lc code=start
class Solution:
    # 定义方向
    d = [(-1,0),(0,1),(1,0),(0,-1)]
    m = 0
    n = 0

    # 函数入口
    def exist(self, board: List[List[str]], word: str) -> bool:
        if len(board) == 0 :
            return False
        self.m = len(board)
        self.n = len(board[0])
        # self.isVisited = [[False]*self.n]*self.m 
        # self.isVisited = [[ False for j in range(self.n) ] for i in range(self.m)]
        # print(self.isVisited)
        for i in range(self.m):
            for j in range(self.n):
                # 如果找到了就返回True
                # 没找到就循环找
                # 把第一步判断提到外层，不要递归
                if board[i][j] == word[0]:
                    if self.findWord(board, word, i,j):
                        return True

        return False


    def isValid(self, x, y):
        return x>= 0 and x<self.m and y >=0 and y< self.n

    # 回溯主体
    def findWord(self, board, word, x, y):
        # 如果不匹配，或被访问过，返回False.
        if board[x][y] != word[0]: 
            return False
            
        # 定义递归出口
        if len(word)==1 :
            return board[x][y] == word[0]
        # 进入递归体 误写了==号   
        board[x][y] = None  
        # print(self.isVisited)
        for i in range(4):
            newX = x + self.d[i][0]
            newY = y + self.d[i][1]
            # print(newX, newY,word[1:])
            if self.isValid(newX, newY) and self.findWord(board,word[1:], newX, newY):
                
                return True
        # 四周没找到，回滚，误写了==号
        board[x][y] = word[0]       
        return False


        

        
# @lc code=end

