#
# @lc app=leetcode id=3168 lang=python
#
# [3168] Minimum Number of Chairs in a Waiting Room
#

# @lc code=start
class Solution(object):
    def minimumChairs(self, s):
        """
        :type s: str
        :rtype: int
        """
        max_chairs = 0
        chairs = []
        for i in s:
            if i == 'E':
                chairs.append(i)
                if len(chairs) > max_chairs:
                    max_chairs = len(chairs)
            else:
                chairs.pop()
        return max_chairs
        
# @lc code=end

