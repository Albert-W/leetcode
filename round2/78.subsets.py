#
# @lc app=leetcode id=78 lang=python3
#
# [78] Subsets
#

# @lc code=start
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return [[]]
        # if 
        pre = self.subsets(nums[:-1])
        res = []
        # print(pre)
        for i in pre:
            res.append(i[:])
            i.append(nums[-1])
            res.append(i)
        return res
        
# @lc code=end

