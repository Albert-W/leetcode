#
# @lc app=leetcode id=999 lang=python3
#
# [999] Available Captures for Rook
#

# @lc code=start
class Solution:
    def numRookCaptures(self, board: List[List[str]]) -> int:
        row = 0
        col = 0
        res = 0
        # find the index of rook
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 'R':
                    row = i
                    col = j
        i = row - 1
        while i >= 0: 
            if board[i][col] == 'p':
                res += 1
                break
            elif board[i][col] != '.':
                break  
            i -= 1
        i = row + 1
        while i < len(board):
            if board[i][col] == 'p':
                res += 1
                break
            elif board[i][col] != '.':
                break  
            i += 1
        j = col - 1
        while j >= 0: 
            if board[row][j] == 'p':
                res += 1
                break
            elif board[row][j] != '.':
                break  
            j -= 1
        j = col + 1
        while j < len(board): 
            if board[row][j] == 'p':
                res += 1
                break
            elif board[row][j] != '.':
                break  
            j += 1      
        return res          
        
# @lc code=end

