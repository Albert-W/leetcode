#
# @lc app=leetcode id=3184 lang=python
#
# [3184] Count Pairs That Form a Complete Day I
#

# @lc code=start
class Solution(object):
    def countCompleteDayPairs(self, hours):
        """
        :type hours: List[int]
        :rtype: int
        """
        res = 0
        for i in range(len(hours)):
            for j in range(i+1, len(hours)):
                if (hours[i] + hours[j]) % 24 == 0:
                    res += 1
        return res
        
# @lc code=end

