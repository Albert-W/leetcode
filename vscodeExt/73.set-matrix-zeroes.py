#
# @lc app=leetcode id=73 lang=python3
#
# [73] Set Matrix Zeroes
#

# @lc code=start
class Solution:
    def setZeroes(self, matrix) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        # find all zeros
        si = set()
        sj = set()
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    si.add(i)
                    sj.add(j)
                    print(i,j)
        # clear the numbers
        for i in range(len(matrix)):
            if i in si:
                matrix[i]=[0]*len(matrix[0])
                print(matrix[i])
            else:    
                for j in range(len(matrix[0])):
                    if j in sj:
                        matrix[i][j] =0 
                    
# @lc code=end

matrix = [[1,1,1],[1,0,1],[1,1,1]]
s = Solution()
s.setZeroes(matrix)
print(matrix)