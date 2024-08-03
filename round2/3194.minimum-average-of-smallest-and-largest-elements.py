#
# @lc app=leetcode id=3194 lang=python
#
# [3194] Minimum Average of Smallest and Largest Elements
#

# @lc code=start
class Solution(object):
    def minimumAverage(self, nums):
        """
        :type nums: List[int]
        :rtype: float
        """
        sorted_nums = sorted(nums)
        avgs = []
        l = len(sorted_nums)
        for i in range(l//2):
            avgs.append(float(sorted_nums[i] + sorted_nums[l - i - 1]) / 2)
            # print(avgs)
        return min(avgs)
        
# @lc code=end

