#
# @lc app=leetcode id=89 lang=python3
#
# [89] Gray Code
#

# @lc code=start
class Solution:
    def grayCode(self, n: int) -> List[int]:
        if n == 0:
            return [0]
    # 需要一点的观察能力
        res = []
        tmp = self.grayCode(n-1)
        res += tmp 
        for i in tmp[::-1]:
            res.append(i + 2**(n-1))
        return res 
        
# @lc code=end

