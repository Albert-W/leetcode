#
# @lc app=leetcode id=47 lang=python3
#
# [47] Permutations II
#

# @lc code=start
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        # 出口需要注意，返回值其实应该是[ [] ] 结构
        if len(nums) == 0:
            return []
        if len(nums) == 1:
            return [nums]    
        res = []  
        # 唯一的修改就是添加set() 进行去重，此时不通使用pop,只能用remove.   
        for i in set(nums):
            new = nums[:]
            # pop 需要按index删除
            new.remove(i)
            tem = self.permuteUnique(new)
            for j in tem:
                j.append(i)
                res.append(j)
                
        return res        
        
# @lc code=end

