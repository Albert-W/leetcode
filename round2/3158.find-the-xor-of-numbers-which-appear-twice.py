#
# @lc app=leetcode id=3158 lang=python
#
# [3158] Find the XOR of Numbers Which Appear Twice
#

# @lc code=start
class Solution(object):
    def duplicateNumbersXOR(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = 0
        s = set()
        dup = []
        for i in nums:
            if i in s:
                dup.append(i)
            else:
                s.add(i)
        for j in dup:
            res ^= j
        return res
# @lc code=end

