#
# @lc app=leetcode id=279 lang=python3
#
# [279] Perfect Squares
#

# @lc code=start

# import math
class Solution:

    # 必须利用最优子结构，即从小开始往大记录。  
    # Time Limit Exceeded
    # 8405
    # res[i]= min(res[i-j*j]) + 1 。 
    def numSquares(self, n: int) -> int:
        res = [n]*(n+1)
        res[0] = 0
        res[1] = 1
        i = 1
        while i**2 <= n:
            res[i**2] = 1
            i += 1
        while i<= n:
            j = 1
            while j*j <= i:
                res[i] = min(res[i-j*j] + 1, res[i])
                j+=1
            i+=1
        return res[n]             


    # 使用了静态空间通过了。 
    _dp = [0]
    def numSquares(self, n):
        dp = self._dp
        while len(dp) <= n:
            dp += min(dp[-i*i] for i in range(1, int(len(dp)**0.5+1))) + 1,
        return dp[n]              

    # BFS 宽度有限的遍历， 
    # 队列首部是步数最小的情型。 
    # 增加step，减少num. 一增一减。
    def numSquares(self, n: int) -> int:
        q = [] # list(num -> steps)
        q.append((n, 0)) # take zero step to arrive n 
        # 247 -> 7927 队列去重之后的性能提升。
        visited = [False]*(n+1)
        visited[n] = True

        while len(q):
            num = q[0][0]
            steps = q[0][1]
            del q[:1]

            if num == 0 : 
                return steps # take steps to arrive zero

            i = 0 
            while 1 :
                a = num - i**2
                if a<0:
                    break
                # 判断提前之后，成功通过了, 用时996ms 
                # 变量计算统一为a,之后，用时768ms
                # list 改为tuple 之后，用时576ms
                 
                if a == 0:
                    return steps + 1
                if not visited[a]:
                    q.append((a, steps + 1));
                    visited[a]=True
                i+=1    
                          


# @lc code=end

