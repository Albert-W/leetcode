#
# @lc app=leetcode id=1 lang=python3
#
# [1] Two Sum
#

# @lc code=start
# Your runtime beats 5.03 % of python3 submissions
# Your memory usage beats 16.51 % of python3 submissions (14.7 MB)
# 
# 注解
# 1，对有序循环，还可以使用双索引，时空都为O(1)
# 2, 对无序循环，使用dict, 空间O(n)


# 暴力双重循环
class Solution_1:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        l = len(nums)
        for i in range(l):
            j = i+1
            while j < l :
                if nums[i] + nums [j] == target:
                    res = [i, j]
                    return res 
                j += 1  


# dict(key:expected number, value: index of original number)
# KeyError 即找不到key. 
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        l = len(nums)
        d = {}
        for i in range(l):
            if nums[i] in d :
                return [ d[nums[i]], i]
            else :
                d[target - nums[i]] = i



# @lc code=end

