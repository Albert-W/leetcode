#
# @lc app=leetcode id=46 lang=python3
#
# [46] Permutations
#

# @lc code=start
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        if len(nums) <= 1:
            return [nums]
        
        for i in nums:
            rest = nums.copy()
            rest.remove(i)
            rest_permute = self.permute(rest)
            for p in rest_permute:
                res.append(p + [i])
        return res
# @lc code=end

