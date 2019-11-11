#
# @lc app=leetcode id=46 lang=python3
#
# [46] Permutations
#

# @lc code=start
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        # 出口需要注意，返回值其实应该是[ [] ] 结构
        if len(nums) == 0:
            return []
        if len(nums) == 1:
            return [nums]    
        res = []    
        for i in nums:
            new = nums[:]
            # pop 需要按index删除
            new.remove(i)
            tem = self.permute(new)
            for j in tem:
                j.append(i)
                res.append(j)
                
        return res
        
# @lc code=end

