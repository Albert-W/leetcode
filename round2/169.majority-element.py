#
# @lc app=leetcode id=169 lang=python
#
# [169] Majority Element
#

# @lc code=start
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Count of the majority > Count of the rest
        res = nums[0]
        count = 1
        for i in nums:
            if i == res:
                count += 1
            else:
                count -= 1
                if count == 0:
                    res = i
                    count = 1
        return res
            
        
# @lc code=end

