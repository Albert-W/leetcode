#
# @lc app=leetcode id=51 lang=python3
#
# [51] N-Queens
#

# @lc code=start
class Solution:
    chess = []
    record = []
    # 存储最终结果
    result = []
    def solveNQueens(self, n: int) -> List[List[str]]:
        # 重置棋盘
        self.chess = [ ['.' for i in range(n)] for j in range(n)]
        # print(self.chess)
        # 防止上次调用的结果污染
        self.result = []
        # 初始摆放位置,放便判断是否合法
        # record index = row; value = column
        self.record = [-1]*n
        # 将剩下的n个皇后摆入record之中。
        # 初始为n, n-1,...0
        self.dfs(n)
        return self.result
    # 将剩下的n个皇后摆入record之中。
    def dfs(self, n):
        rowN = len(self.chess)
        snapshot = []
        if n==0: # 全部摆完之后
            for i in range(rowN):
                # 每一行强转为字符串
                snapshot.append( ''.join(self.chess[i]))
            # 当前旗盘存入结果中    
            self.result.append(snapshot)    

        # 首先处理第n子
        # 就放在第n-1行
        row = n-1
        # 遍历寻找列，可以放在列[n-1, i]
        for i in range(rowN):
            col = i
            # 如果当前位置可以放下去
            if self.isValid(row, col):
                # print(row,col)
                self.chess[row][col] = 'Q'
                self.record[row] = col # 记录落子信息
                self.dfs(n-1)
                # 没有成功则复原
                self.chess[row][col] = '.'
                self.record[row] = -1

    def isValid(self, row, col):
        # 从[n-1, n-2, row]
        for i in range(len(self.record)-1,row-1,-1):
            # [i, record[i]] 与 [row, col] 比较
            # 如果己摆的位置与要添的位置在同一列
            if self.record[i] == col or abs( i - row) == abs(self.record[i]-col):
                return False
        return True        


        
# @lc code=end

