#
# @lc app=leetcode id=1985 lang=python
#
# [1985] Find the Kth Largest Integer in the Array
#

# @lc code=start
class Solution(object):
    def kthLargestNumber(self, nums, k):
        """
        :type nums: List[str]
        :type k: int
        :rtype: str
        """
        return sorted(nums, reverse=True, key=lambda x: int(x))[k-1]
        
# @lc code=end

