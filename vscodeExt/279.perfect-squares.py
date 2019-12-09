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
        res = [n]*(n+1) # 存储第i个数的最小完全平方
        res[0] = 0
        res[1] = 1
        i = 1
        # 填上1，4，9，16，
        while i**2 <= n:
            res[i**2] = 1
            i += 1
        # 开始循环并使用动态规划，进行遍历。 
        while i<= n:
            j = 1
            while j*j <= i:
                # 得到最小的 完全平方数
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
        # n -> n 需要0步
        # n -> n-1， n-4, n-9 需要1 步。
        # 排到靠前的都是最小步数的走法，直到得到零。 
        # 13 ：[(13,0),|(12,1),(9,1),(4,1),|(11,2),(8,2)...]
        q = [] 
        q.append((n, 0)) 
        # 247数量集 -> 7927 队列去重之后的性能提升。
        # 防止 把己访问的目标 推入 队列中。 
        visited = [False]*(n+1)
        visited[n] = True

        while len(q):
            # 目标
            num = q[0][0]
            # 当前步数
            steps = q[0][1]
            del q[:1]
            # n -> 0, 所需要的步数，即结果
            if num == 0 : 
                return steps # take steps to arrive zero

            i = 1 
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

