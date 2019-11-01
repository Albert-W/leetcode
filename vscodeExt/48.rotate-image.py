#
# @lc app=leetcode id=48 lang=python3
#
# [48] Rotate Image
#

# @lc code=start
class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """

        l = len(matrix)    
        for i in range(l):
            for j in range(i+1, l):
               matrix[i][j], matrix[j][i] = matrix[j][i],matrix[i][j]
        for i in matrix:
            i.reverse()

        
# @lc code=end

