#
# @lc app=leetcode id=303 lang=python3
#
# [303] Range Sum Query - Immutable
#

# @lc code=start
class NumArray:

    # 转化合 先求和，再求差
    def __init__(self, nums: List[int]):
        if len(nums):
            self.sum = [nums[0]] * len(nums)
        # 求出累加和
        for i in range(1,len(nums)):
            self.sum[i] = self.sum[i-1]+nums[i]
        # print(self.sum)    
        

    # sum[i,j] = sum[0,j] - sum[i-1]
    def sumRange(self, i: int, j: int) -> int:
        if i == 0:
            return self.sum[j]
        else:   
            return self.sum[j] - self.sum[i-1]


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(i,j)
# @lc code=end

