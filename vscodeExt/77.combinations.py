#
# @lc app=leetcode id=77 lang=python3
#
# [77] Combinations
#

# @lc code=start
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        # C2，2 = 1
        if n < k or k == 0 or n==0:
            return None 

        # Cn,1 = n    
        res = []
        if k == 1:
            for i in range(1, n+1 ):
                res.append([i])
            return res    # 这是二维数组 
        # c n,n == 1    
        if n == k:
            return [list(range(1,n+1))]
            
        # [n, n-1, n-2, k] 
        # 进行剪枝，避免无效循环  
        # 倒序取数  
        for i in range(n, k-1, -1):
            # 每次最后数开始取，取过之后不可再取，以去重。 
            temp = self.combine( i-1, k-1)
            if temp:
                for j in temp:
                    j.append(i)
                    res.append(j)
        return res        
            
        
# @lc code=end

