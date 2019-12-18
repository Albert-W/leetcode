#
# @lc app=leetcode id=307 lang=python3
#
# [307] Range Sum Query - Mutable
#

# @lc code=start
class BIT(object):
    def __init__(self, n):
        self.bit = [0]* (n+1) 
        self.n = n

    def lowbit(self, x):
        return x & -x

    # 给x位置的值增加 val  
    def add(self, x, val):
        # 当 x = 0 进行死循环
        while x <= self.n:
            self.bit[x] += val
            x += self.lowbit(x)

    # query [0, x) 
    def query(self, x):
        res = 0 
        while x > 0:
            res += self.bit[x]
            x -= self.lowbit(x)
        return res    


class NumArray:
    def __init__(self, nums: List[int]):
        self.nums = nums
        # 创建并初始化 binary indexted tree
        self.bit = BIT(len(nums))
        for i , v in enumerate(nums):
            # 在tree中下标是从1开始
            self.bit.add(i+1, v)
        # print(self.bit.bit)
        # print(self.bit.query(1))


    def update(self, i: int, val: int) -> None:
        # 当index 为0 时进入死循环
        self.bit.add(i + 1, val - self.nums[i])
        self.nums[i] = val
        
    # [i, j ] = query[j+1] - query[i]
    def sumRange(self, i: int, j: int) -> int:
        return self.bit.query(j+1) - self.bit.query(i)


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(i,val)
# param_2 = obj.sumRange(i,j)
# @lc code=end

