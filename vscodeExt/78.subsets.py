#
# @lc app=leetcode id=78 lang=python3
#
# [78] Subsets
#

# @lc code=start
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if len(nums) ==0:
            return [[]]
        # if len(nums) == 1:
        #     return [[],[nums[0]] ]   
        res = []
        temp = self.subsets(nums[:-1])
        # res.extend(temp)
        print(temp)
        for item in temp:
            res.append(item[:])
            item.append(nums[-1])
            res.append(item[:])
        return res             

# @lc code=end

