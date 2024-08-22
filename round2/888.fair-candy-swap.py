#
# @lc app=leetcode id=888 lang=python
#
# [888] Fair Candy Swap
#

# @lc code=start
class Solution(object):
    def fairCandySwap(self, aliceSizes, bobSizes):
        """
        :type aliceSizes: List[int]
        :type bobSizes: List[int]
        :rtype: List[int]
        """
        diff = sum(aliceSizes) - sum(bobSizes)
        B = set(bobSizes) # save 80% time compared to list
        for a in set(aliceSizes):
            if (a - diff/2) in B: # Should not create set inside loop 
                return [a, int(a - diff/2)]
        
# @lc code=end

