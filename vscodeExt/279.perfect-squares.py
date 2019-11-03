#
# @lc app=leetcode id=279 lang=python3
#
# [279] Perfect Squares
#

# @lc code=start

# import math
class Solution:
    # Time Limit Exceeded
    def numSquares_E1(self, n: int) -> int:
        res = [n] * (n+1)
        res[1] = 1
        i = 1
        while i <=n:
            sqrt = int(i**0.5)
            if sqrt ** 2 == i:
                res[i]=1
            else :
                j = 1
                while j <= i//2:
                    res[i]= min(res[j]+ res[i-j],res[i]);
                    j+=1    

            i+=1
        return res[n]    

    # Time Limit Exceeded
    # 8328
    def numSquares(self, n: int) -> int:
        res = [n] * (n+1)
        res[1] = 1
        i = 1
        while i*i <=n:
            res[i*i]=1
            i += 1    
        i =1 
        while i<=n :   
            j = 1
            while i+ j*j <= n:
                res[i + j * j]= min(res[i]+ 1,res[i + j * j]);
                j+=1    
            i+=1
        return res[n]
        
# @lc code=end

