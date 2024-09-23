#
# @lc app=leetcode id=215 lang=python
#
# [215] Kth Largest Element in an Array
#

# @lc code=start
import heapq
class Solution(object):
    def findKthLargest(self, nums, k):
        return heapq.nlargest(k, nums)[-1]
            
    def findKthLargest_1(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        _nums = sorted(nums, reverse=True)
        return _nums[k-1]
        
# @lc code=end

