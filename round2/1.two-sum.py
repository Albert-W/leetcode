#
# @lc app=leetcode id=1 lang=python
#
# [1] Two Sum
#

# @lc code=start
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # Using dictionary to store the info from visited elements
        # key: num
        # value: index of num
        d = {}
        for i, num in enumerate(nums):
            if target - num in d:
                return [d[target - num], i]
            else:
                d[num] = i
        return None        
# @lc code=end

