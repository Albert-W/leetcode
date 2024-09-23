#
# @lc app=leetcode id=1310 lang=python3
#
# [1310] XOR Queries of a Subarray
#

# @lc code=start
class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
       # a ^ b = c -> a = c ^ b 

        if len(arr) == 0:
           return []
        memo = []
        memo.append(arr[0])
        # print(memo)
        for i in arr[1:]:
            tmp = memo[-1] ^ i 
            memo.append(tmp) 
        # print(memo) 
        
        res = []
        for i in range(len(queries)):
            if queries[i][0] == 0:
                res.append(memo[queries[i][1]])
            else: 
                # print(memo[queries[i][1]] , memo[queries[i][0] - 1])
                t = memo[queries[i][1]] ^ memo[queries[i][0] - 1]
                res.append(t)
        return res
        
# @lc code=end

