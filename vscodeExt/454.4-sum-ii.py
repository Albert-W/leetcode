#
# @lc app=leetcode id=454 lang=python3
#
# [454] 4Sum II
#

# @lc code=start
class Solution:
    def fourSumCount(self, A: List[int], B: List[int], C: List[int], D: List[int]) -> int:
        d = {}
        for i in A:
            for j in B:
                if i + j in d:
                    d[i+j] += 1
                else:
                    d[i+j] = 1

        res = 0 
        for l in C:
            for m in D:
                if -l -m in d:
                    res += d[-l-m]
        return res                            
        
# @lc code=end

